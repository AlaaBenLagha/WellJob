package com.pidev.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pidev.repository.UserRepository;
import com.pidev.repository.VerificationTokenRepository;
import com.pidev.security.JwtProvider;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class BadWordFilter {

	private static int largestWordLength = 0;

	  private static Map<String, String[]> allBadWords = new HashMap<String, String[]>();


	  public String getCensoredText(final String input) {
		  loadBadWords();
	    if (input == null) {
	      return "";
	    }

	    String modifiedInput = input;


	    modifiedInput = modifiedInput.toLowerCase().replaceAll("[^a-zA-Z]", "");

	    ArrayList<String> badWordsFound = new ArrayList<>();

	    for (int start = 0; start < modifiedInput.length(); start++) {
	      for (int offset = 1; offset < (modifiedInput.length() + 1 - start) && offset < largestWordLength; offset++) {
	        String wordToCheck = modifiedInput.substring(start, start + offset);
	        if (allBadWords.containsKey(wordToCheck)) {
	          String[] ignoreCheck = allBadWords.get(wordToCheck);
	          boolean ignore = false;
	          for (int stringIndex = 0; stringIndex < ignoreCheck.length; stringIndex++) {
	            if (modifiedInput.contains(ignoreCheck[stringIndex])) {
	              ignore = true;
	              break;
	            }
	          }
	          
	          if (!ignore) {
	            badWordsFound.add(wordToCheck);
	          }
	        }
	      }
	    }

	    String inputToReturn = input;
	    for (String swearWord : badWordsFound) {
	      char[] charsStars = new char[swearWord.length()];
	      Arrays.fill(charsStars, '*');
	      final String stars = new String(charsStars);

	      inputToReturn = inputToReturn.replaceAll("(?i)" + swearWord, stars);
	    }

	    return inputToReturn;
	  } 

	  private static void loadBadWords() {
	    int readCounter = 0;
	    try {
    
	    	BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("https://docs.google.com/spreadsheets/d/1V0a-37A739kHzlSSvRAPKMlDSBYtWxPKwPzczP-ICXY/export?format=csv").openConnection().getInputStream()));
	      
	      
	      String currentLine = "";
	      while ((currentLine = reader.readLine()) != null) {
	        readCounter++;
	        String[] content = null;
	        try {
	          if (1 == readCounter) {
	            continue;
	          }

	          content = currentLine.split(",");
	          if (content.length == 0) {
	            continue;
	          }

	          final String word = content[0];

	          if (word.startsWith("-----")) {
	            continue;
	          }

	          if (word.length() > largestWordLength) {
	            largestWordLength = word.length();
	          }

	          String[] ignore_in_combination_with_words = new String[] {};
	          if (content.length > 1) {
	            ignore_in_combination_with_words = content[1].split("_");
	          }

	          allBadWords.put(word.replaceAll(" ", "").toLowerCase(), ignore_in_combination_with_words);
	        } catch (Exception except) {
	        }
	      } 
	    } catch (IOException except) {
	    }
	  } 

}

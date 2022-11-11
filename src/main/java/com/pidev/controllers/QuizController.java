package com.pidev.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.pidev.models.Category;
import com.pidev.models.Quiz;
import com.pidev.serviceInterface.QuizService;
import lombok.AllArgsConstructor;






@AllArgsConstructor
@RestController
@RequestMapping("/api/quiz/")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	

	@PostMapping("/add")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
		Quiz theQuiz=this.quizService.addQuiz(quiz);
		return ResponseEntity.ok(theQuiz);
	}
	
	
	
	@Async
	@GetMapping("/{quizId}")
	@ResponseBody
	public Quiz getQuiz(@PathVariable("quizId") Long qid) throws Exception {
		Quiz quiz=this.quizService.getQuizById(qid);
		return quiz;
	}
	

	@GetMapping("/getAllQuiz")
	public ResponseEntity<?> getAllCategory() throws Exception{
		Set<Quiz> quizzes=this.quizService.getQuizzes();
		if(quizzes==null) {
			throw new Exception("there is no quiz in the database");
		}
		return ResponseEntity.ok(quizzes);
	}
	
	
	@PutMapping("/updateQuiz")
	public ResponseEntity<Quiz> updateCategory(@RequestBody Quiz quiz) {
		Quiz thequiz=this.quizService.updateQuiz(quiz);
		return ResponseEntity.ok(thequiz);
	}
	

	@DeleteMapping("/{quizId}")
	public void deleteCategory(@PathVariable("quizId") Long qid) throws Exception {
		Quiz quiz=this.quizService.getQuizById(qid);
		if(quiz==null) {
			throw new Exception("Quiz not found exception");
		}
		this.quizService.deleteQuiz(qid);
	}
	
	

	@GetMapping("/Bycategory/{cid}")
	public ResponseEntity<?> getQuizzesByCategoryId(@PathVariable("cid") Long cid){
		Category category=new Category();
		category.setCid(cid);
		return ResponseEntity.ok(this.quizService.findQuizzesByCategoryId(category));
	}
	
	

	@GetMapping("/active")
	public ResponseEntity<?> getAllActiveQuizzes(){
		return ResponseEntity.ok(this.quizService.findAllActiveQuiz());
	}
	

	@GetMapping("/category/active/{cid}")
	public ResponseEntity<?> getAllActiveQuizzesOfCategory(@PathVariable("cid") Long cid){
		Category category=new Category();
		category.setCid(cid);
		return ResponseEntity.ok(this.quizService.findAllActiveQuizOfCategory(category));
	}
	
	
	
	@Autowired
	private QueryParser translater;
    
	
	
	@Async
	@GetMapping("/search/{content}")
	public ResponseEntity<ArrayList<Quiz>> searchlist(@PathVariable("content") String content) {
		ArrayList<String> word_list = (ArrayList<String>) translater.parseQuery(content);
		HashSet<String> keywords_set = new HashSet<String>();
		for (int i = 0; i < word_list.size(); i++) {
			keywords_set.add(word_list.get(i));
		}

		ArrayList<Quiz> quiz_list = (ArrayList<Quiz>) quizService.findAllActiveQuiz();
		ArrayList<Quiz> candidates = new ArrayList<Quiz>();
		

		for (int i = 0; i < quiz_list.size(); i++) {
			if (keywords_set.contains(quiz_list.get(i).getQid())) {
				candidates.add(quiz_list.get(i));
				int index;

			}
		}
		
		

		for (int i = 0; i < quiz_list.size(); i++) {
			String temp[] = quiz_list.get(i).getTitle().split("[^a-zA-Z0-9']+");
			int count = 0;

			for (String str : temp ) {
				if (keywords_set.contains(str)) {
					count++;	
				}
		
				
				
				
				
				

			}
				
			
			
			if (count > 0) {

				quiz_list.get(i).setKeywords_number(count);
				candidates.add(quiz_list.get(i));

			}
				
			
			
			
			
			

		}	
		
		Collections.sort(candidates, new SortingMethod());
	
		return ResponseEntity.ok(candidates);
	}
	
	
	
	class SortingMethod implements Comparator<Quiz> {

		@Override
		public int compare(Quiz q1, Quiz q2) {
			double score1 = q1.getViews()*0.1+ q1.getKeywords_number()*10;
			double score2 = q2.getViews()*0.1 + q2.getKeywords_number()*10;
			if (score1 > score2) {
				return -1;
			}else {
				return 1;
			}
		}
			
			
			
		

	
}
}
	

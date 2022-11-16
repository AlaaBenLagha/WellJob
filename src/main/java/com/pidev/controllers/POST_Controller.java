package com.pidev.controllers;


import com.pidev.models.Answer;
import com.pidev.models.Ask;
import com.pidev.models.User;
import com.pidev.service.AuthService;
import com.pidev.serviceInterface.IAnswerService;
import com.pidev.serviceInterface.IAskService;
import com.pidev.serviceInterface.QuizService;
import com.pidev.serviceInterface.UserService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@AllArgsConstructor
@RestController
@RequestMapping("/api/communitypost/")
public class POST_Controller {
    @Autowired
    private IAnswerService questionAnswerInterfaceOperation;
    @Autowired
    private UserService userInterfaceOperation;
    @Autowired
    private IAskService questionsInterfaceOperation;
    private final AuthService authService;
    

    
//    @Autowired
//    private JavaMailSender javaMailSender;
 
//    @Autowired block list interface

    
    
    
    
    

     // this the user answer the question
    
//    {
//	"email":"Alaa@bellagha.com",
//	"answer":"26",
//	"question":"how old"
//    }
    
    @PostMapping("/answerQuestion/{questionId}")
    public void  Ask (@PathVariable("questionId") Long id , @RequestBody Answer answer){
       try{
    	   Ask ask = questionsInterfaceOperation.getAskById(id);
           answer.setUser(authService.getCurrentUser());
           answer.setTime(java.time.Instant.now());
           answer.setAsk(ask);
           questionAnswerInterfaceOperation.saveAnswerofQuestion(answer);

       }catch (Exception ex){
           System.out.println(ex.getMessage());

       }
    }

    // add to block list -> you will sent email want to bloc in post
    
//    {
//	"email":"T@T.com"
//    }
    
    
    // Block List 
    
    
    
//    @PostMapping(value = "/block/{owner}")
//    public void  addToBlockList(@PathVariable("owner") String ownerEmail , @RequestBody BlockList blockList){
//        try{
//            if(!ownerEmail.equals("null")) {
//                User user = userInterfaceOperation.getUserByEmail(ownerEmail);
//                blockList.setUser(user);
//            }
//            // save block
//            blockInterfaceOperation.addUserToBlockList(blockList);
//
//        }catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }
//
//    }

    
    
    
    // add new question
    //user you want to ask him
    /*
    * {
	"question":"W_A_Y",
	"email":"T@T.com" this is me
    }
    * */
    @PostMapping("/askUser")
    public  void addAsk(@RequestBody Ask question){
        try{
            User theUser = userInterfaceOperation.findUser(authService.getCurrentUser().getUsername());
            question.setUser(theUser);
            question.setTime(java.time.Instant.now());
            questionsInterfaceOperation.saveQuestion(question);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    // add user -> work
    /*
    {
      "email": "T@T.com",
      "fullName": "TTTTTT",
       "userSetting": {
        "location": "tnata",
        "bio": "",
        "anotherWebSites": null,
        "hashTags": "",
        "userName": "TAREK",
        "dateOfBirth":null,
        "gender": "FEMALE",
        "privacyQuestion": null
       }
}
//    * */
//    @PostMapping(value = "/addUser")
//    public  void addNewUser(@RequestBody User user){
//        try {
//            User userProfile = new User();
//              user.setUserProfile(userProfile);
//
//            SimpleMailMessage message = new SimpleMailMessage();
//            message.setTo(user.getEmail());
//            message.setSubject("this is out code");
//            message.setText("12345");
//            javaMailSender.send(message);
//
//            userInterfaceOperation.addUser(user);
//        }catch (Exception ex){
//            System.out.println(ex.getMessage());
//
//        }
//    }
//
//    private boolean sendEmail(){
//
//    return true;
//    }


}

//package com.example.demo.MainController;
//
//import com.example.demo.ServiceInterface.QuestionsInterfaceOperation;
//import com.example.demo.ServiceInterface.UserInterfaceOperation;
//import com.example.demo.XReposotry.QuestionRepo;
//import com.example.demo.XReposotry.UserRepo;
//import com.example.demo.ZModel.Questions;
//import com.example.demo.ZModel.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping(value = "deleteApi")
//public class DELETE_Controller {
//    @Autowired
//    private UserInterfaceOperation userInterfaceOperation;
//    @Autowired
//    private QuestionsInterfaceOperation questionsInterfaceOperation;
//
//
//    /********************************** all work *****************************/
//
//    @DeleteMapping(value = "/deleteUser/{email}" )
//    public void deleteUser(@PathVariable("email") String email){
//        try {
//            userInterfaceOperation.deleteTheUser(email);
//        }catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }
//    }
//
//    @DeleteMapping(value = "/delete/{indexQuestion}")
//    public void deleteOneQuestion(@PathVariable("indexQuestion") Long id) {
//        try {
//            questionsInterfaceOperation.deleteOneUserQuestion(id);
//        }catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }
//    }
//
//    @DeleteMapping(value = "/deleteAllUserQuestions/{email}")
//    public void deleteAllQuestionUser(@PathVariable("email") String email){
//        try {
//            User user = userInterfaceOperation.getUserByEmail(email);
//            questionsInterfaceOperation.deleteAllUserQuestion(user);
//        }catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }
//
//    }
//
//}

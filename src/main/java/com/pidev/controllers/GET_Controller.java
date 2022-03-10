package com.pidev.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pidev.models.Answer;
import com.pidev.models.Ask;
import com.pidev.models.User;
import com.pidev.serviceInterface.IAnswerService;
import com.pidev.serviceInterface.IAskService;
import com.pidev.serviceInterface.ICo_WorkerService;
import com.pidev.serviceInterface.UserService;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/communityget/")
public class GET_Controller {
    // interface
    @Autowired
    private UserService userInterfaceOperation;
    @Autowired
    private IAnswerService questionAnswerInterfaceOperation;
    @Autowired
    private ICo_WorkerService friendsInterfaceOperation;
    @Autowired
    private IAskService questionsInterfaceOperation;
//    @Autowired
//    private  UserSettingInterfaceOperation userSettingInterfaceOperation;
    // end inject interface

     /* **************************************user****************************************************************/

        @GetMapping("/getOneUser/{email}")
        public User getOneUserControl(@PathVariable("email") String email) {
            try{
                return  userInterfaceOperation.getUserByEmail(email);
            }catch (Exception ex){
                System.out.println("there is a error " +ex.getMessage() );
                return null;
            }
         }

        @GetMapping("/getAllUsers")
        public Object getAllUsers() {
            return userInterfaceOperation.getAllUsers();
        }

        /* **************************************setting****************************************************************/
//        @RequestMapping(value = "/getUserSetting/{email}", method = RequestMethod.GET)
//        public Object getUserSettingControl(@PathVariable(value = "email")String email){
//            try{
//                User TheUser = getOneUserControl(email);
//                return  userSettingInterfaceOperation.getUserSetting(TheUser.getUserSetting().getId());
//            }catch (Exception ex){
//                System.out.println(ex.getMessage());
//                return null;
//            }
//           }

        /* ***************************************post***************************************************************/

        // to return all post or question answer
        @GetMapping("/getAllAnswerQuestion")
        public List<Answer> getAllAnswerQuestionControl(){
            try{
                return questionAnswerInterfaceOperation.getAllQuestionAnswer();
            }catch (Exception ex){
                System.out.println(ex.getMessage());
                return null;
            }
        }

        //this is for one user
        @GetMapping("/getAllUSERAnswerQuestion/{email}")
        public List<Answer> getAllUserAnswerQuestionControl(@PathVariable("email")String email){
            try{
                User TheUser = getOneUserControl(email);
                return questionAnswerInterfaceOperation.getAllUserQuestionAnswer(TheUser);
            }
            catch (Exception x){
                System.out.println(x.getMessage());
                return null;
            }
        }

       /* ********************************************friends**********************************************************/

        @GetMapping("/getUserFriends/{email}")
        public  Object getUserFriendControl(@PathVariable("email") String email) {
            try{
                Object TheUser = getOneUserControl(email);
                return friendsInterfaceOperation.getUserCo_Worker(TheUser);
            }catch (Exception ex){
                System.out.println(ex.getMessage());
                return null;
            }
        }

        /* ********************************************question**********************************************************/
        @GetMapping("/getUserQuestion/{email}")
        public List<Ask> getUserQuestionsControl(@PathVariable("email") String email) {
            try{
                User TheUser = getOneUserControl(email);
                return questionsInterfaceOperation.getUserQuestions(TheUser);
            }catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }

        @GetMapping("/getUserQuestionsNumber/{email}")
        public  Object getUserQuestionsNumberControl(@PathVariable("email") String email) {
            try {
                User TheUser = getOneUserControl(email);
                return questionsInterfaceOperation.getNumberOfQuestionsPerUser(TheUser);
            }catch (Exception ex){
                System.out.println(ex.getMessage());
                return null;
            }

        }



}

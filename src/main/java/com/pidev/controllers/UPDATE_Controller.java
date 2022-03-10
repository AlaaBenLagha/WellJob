//package com.example.demo.MainController;
//
//import com.example.demo.ServiceInterface.UserInterfaceOperation;
//import com.example.demo.ServiceInterface.UserSettingInterfaceOperation;
//import com.example.demo.ZModel.UserSetting;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//
//@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//public class UPDATE_Controller {
//
//    // interface
//    @Autowired
//    private UserInterfaceOperation userInterfaceOperation;
//
//    @Autowired
//    private UserSettingInterfaceOperation userSettingInterfaceOperation;
//
//    // update Setting
//    /*
//    * {
//	"id":4,
//	"location":"not from here",
//	"bio":"simple bio",
//	"anotherWebSites":["true","true","true","true"],
//	"hashTags":"not hash",
//	"userName":"new userNAme",
//	"dateOfBirth":null,
//	"gender":"FEMALE",
//	"privacyQuestion":[true,true,true,true]
//    }
//* */
//    @PutMapping(value = "/updateSetting")
//    public void updateSetting(@RequestBody UserSetting newSetting){
//        try {
//            userSettingInterfaceOperation.updateSetting(newSetting);
//
//        }catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }
//
//    }
//}

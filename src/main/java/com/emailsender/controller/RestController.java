package com.emailsender.controller;

import com.emailsender.model.Email;
import com.emailsender.service.EmailService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private EmailService emailService;
    @PostMapping("/sendMail")
    public Map<String,Object> sendMail(@ModelAttribute Email email, HttpSession session){
        Map<String, Object> result = new HashMap<>();
        try {
            System.out.println(email);
           Boolean isSuccess =emailService.sendMail(email);
           if(isSuccess) {
               result.put("sendMail", "Mail Send Successfully....");
           }else{
               result.put("sendMail","Oops Mail Not Send!!! Something Error.. Please Check your internet connection");
           }

        }catch (Exception e ){
            e.printStackTrace();

        }
         return result;

    }

}

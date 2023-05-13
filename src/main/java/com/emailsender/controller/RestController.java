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
            emailService.sendMail(email);
            result.put("sendMail","Mail Send Successfully....");

        }catch (Exception e ){
            e.printStackTrace();
            result.put("sendMail","Oops Mail Not Send!!! Something Error");
        }
         return result;

    }

}

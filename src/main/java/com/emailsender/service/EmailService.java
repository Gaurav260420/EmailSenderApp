package com.emailsender.service;

import com.emailsender.model.Email;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    public Boolean sendMail(Email em){
        try{
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom("gauravraj.edunext@gmail.com");
            helper.setTo(em.getTo());
            helper.setSubject(em.getSubject());
            helper.setText(em.getMessage());
            javaMailSender.send(message);
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}

package com.cododita.NewsLetterApp.controller;

import com.cododita.NewsLetterApp.bean.EmailData;
import com.cododita.NewsLetterApp.bean.EmailDataObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cododita.NewsLetterApp.service.NotificationService;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;


@RestController
public class EmailNotificationController {

   @Autowired
   public NotificationService notificationService;


    @PostMapping("/sendSimpleMail")
    public String sendSimpleMail(@RequestBody EmailData emailData) {
        return notificationService.sendSimpleMail(emailData);
    }

    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(@RequestBody EmailData emailData) {
        return notificationService.sendMailWithAttachment(emailData);
    }

    @PostMapping("/sendNewsletterEmail")
    public ResponseEntity<Map<String, Object>> sendNewsletterEmail(@RequestBody EmailDataObj emailDataObj) {
        Map<String, Object> response = new HashMap<>();
        try {
            String result = notificationService.sendMailWithHTMLBody(emailDataObj);
            response.put("message", "Email sent successfully");
            response.put("details", result);
            response.put("status", HttpStatus.OK.value());
            return ResponseEntity.ok(response); // 200 OK response with JSON
        } catch (Exception e) {
            response.put("message", "Error sending email");
            response.put("details", e.getMessage());
            response.put("status", HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response); // 400 Bad Request with JSON
        }
    }

    @PostMapping("/sendMailWithHTML_Body")
    public Map<String, String> sendMailWithHTMLBody(
            @RequestParam String receipient,
            @RequestParam String mailSubject,
            @RequestParam(required = false) String mailBody,
            @RequestParam(required = false) MultipartFile htmlFile) {

        Map<String, String> responseMap = new HashMap<>();
        try {
            // Pass the form data and file to the service
            String result = notificationService.sendMailWithHTMLBody(receipient, mailSubject, mailBody, htmlFile);
            responseMap.put("success", result);
        } catch (Exception e) {
            responseMap.put("error", "Error sending email: " + e.getMessage());
        }
        return responseMap;
    }

    @PostMapping("/sendMailWithDynamic_HTML_Body")
    public ResponseEntity<String> sendMailWithDynamic_HTML_Body(@RequestBody EmailData emailData) {
        return new ResponseEntity<String>(notificationService.sendMailWithDynamicHTMlBody(emailData), HttpStatus.OK);
    }
}
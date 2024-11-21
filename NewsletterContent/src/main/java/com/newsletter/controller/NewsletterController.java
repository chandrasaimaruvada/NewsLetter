package com.newsletter.controller;

import com.newsletter.entity.NewsLetter;

import com.newsletter.service.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/newsletter")
@CrossOrigin(origins = "*")
public class NewsletterController {

    @Autowired
    private NewsletterService service;

    @PostMapping
    public ResponseEntity<NewsLetter> createNewsletter(@RequestBody NewsLetter newsletter) {
        NewsLetter savedNewsletter = service.saveNewsletter(newsletter);
        return ResponseEntity.ok(savedNewsletter);
    }

    @GetMapping
    public ResponseEntity<List<NewsLetter>> getAllNewsletters() {
        return ResponseEntity.ok(service.getAllNewsletters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsLetter> getNewsletterById(@PathVariable Long id) {
        return service.getNewsletterById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

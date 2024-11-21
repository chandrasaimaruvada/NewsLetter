package com.newsletter.service;

import com.newsletter.entity.NewsLetter;
import com.newsletter.repo.NewsLetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsletterService {

    @Autowired
    private NewsLetterRepository repository;

//    @CachePut(value = "newsletters", key = "#newsletter.id")
    public NewsLetter saveNewsletter(NewsLetter newsletter) {
        return repository.save(newsletter);
    }

//    @Cacheable(value = "newsletters", key = "'all'")
    public List<NewsLetter> getAllNewsletters() {
        return repository.findAll();
    }

//    @Cacheable(value = "newsletters", key = "#id")
    public Optional<NewsLetter> getNewsletterById(Long id) {
        return repository.findById(id);
    }
}

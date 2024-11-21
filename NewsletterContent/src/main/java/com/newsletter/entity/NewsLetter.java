package com.newsletter.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class NewsLetter{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String welcomeMessage;
    @Column(length = 1000)
    private String programmingLanguages;
    @Column(length = 1000)
    private String upcomingEvents;
    private String featuredProjectTitle;
    @Column(length = 1000)
    private String featuredProjectDescription;
    private String quote;
    private String quoteAuthor;
    @Column(length = 1000)
    private String communityHighlights;

    public NewsLetter() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public String getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void setProgrammingLanguages(String programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }

    public String getUpcomingEvents() {
        return upcomingEvents;
    }

    public void setUpcomingEvents(String upcomingEvents) {
        this.upcomingEvents = upcomingEvents;
    }

    public String getFeaturedProjectTitle() {
        return featuredProjectTitle;
    }

    public void setFeaturedProjectTitle(String featuredProjectTitle) {
        this.featuredProjectTitle = featuredProjectTitle;
    }

    public String getFeaturedProjectDescription() {
        return featuredProjectDescription;
    }

    public void setFeaturedProjectDescription(String featuredProjectDescription) {
        this.featuredProjectDescription = featuredProjectDescription;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getQuoteAuthor() {
        return quoteAuthor;
    }

    public void setQuoteAuthor(String quoteAuthor) {
        this.quoteAuthor = quoteAuthor;
    }

    public String getCommunityHighlights() {
        return communityHighlights;
    }

    public void setCommunityHighlights(String communityHighlights) {
        this.communityHighlights = communityHighlights;
    }
}

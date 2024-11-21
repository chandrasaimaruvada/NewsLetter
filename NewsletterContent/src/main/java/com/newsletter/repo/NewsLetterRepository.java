package com.newsletter.repo;

import com.newsletter.entity.NewsLetter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsLetterRepository extends JpaRepository<NewsLetter, Long> {
}

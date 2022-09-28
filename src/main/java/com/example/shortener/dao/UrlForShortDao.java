package com.example.shortener.dao;

import com.example.shortener.entity.UrlForShort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlForShortDao extends JpaRepository<UrlForShort, Long> {
    UrlForShort findUrlForShortByOriginalUrl(String url);
    UrlForShort findUrlForShortsById(String url);
}

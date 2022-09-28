package com.example.shortener.service;

import com.example.shortener.dao.UrlForShortDao;
import com.example.shortener.dto.UrlForShortDto;
import com.example.shortener.entity.UrlForShort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlForShortDao urlForShortDao;

    @Transactional
    public UrlForShort getShortUrl(UrlForShortDto urlForShort) {
        UrlForShort byUrl = urlForShortDao.findUrlForShortByOriginalUrl(urlForShort.getUrl());
        if (byUrl != null) {
            return byUrl;
        }
        UrlForShort newUrlForShort = generateShotUrl(urlForShort);

        urlForShortDao.save(newUrlForShort);
        return newUrlForShort;
    }

    public String getShortUrl(String url) {
        UrlForShort byUrl = urlForShortDao.findUrlForShortsById(url);
        if (byUrl != null) {
            return byUrl.getOriginalUrl();
        }
        throw new RuntimeException();
    }

    private UrlForShort generateShotUrl(UrlForShortDto urlForShort) {
        UrlForShort newUrlForShort = new UrlForShort();
        newUrlForShort.setId(urlForShort.getUrl().toCharArray()[0] + String.valueOf(urlForShort.getUrl().hashCode()));
        newUrlForShort.setTitle("");
        newUrlForShort.setOriginalUrl(urlForShort.getTitle());
        return newUrlForShort;
    }
}

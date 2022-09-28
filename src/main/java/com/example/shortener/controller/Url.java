package com.example.shortener.controller;

import com.example.shortener.dto.UrlForShortDto;
import com.example.shortener.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/shortner")
@RequiredArgsConstructor
public class Url {
    private final UrlService urlService;

    @PostMapping("/shot")
    public ResponseEntity<String> shortnerUrl(@RequestBody UrlForShortDto urlForShort) {
        return ResponseEntity.status(HttpStatus.CREATED).body(urlService.getShortUrl(urlForShort).getId());
    }

    @GetMapping("/shot/{shortenUrlId}")
    public RedirectView getShortnerUrl(@PathVariable String shortenUrlId) {
        return new RedirectView(urlService.getShortUrl(shortenUrlId));
    }
}

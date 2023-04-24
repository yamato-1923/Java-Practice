package com.flashcard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FlashcardController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}

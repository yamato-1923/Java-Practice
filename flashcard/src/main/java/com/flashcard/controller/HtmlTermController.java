package com.flashcard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flashcard.entity.Term;
import com.flashcard.service.TermService;

@Controller
public class HtmlTermController {

    private final TermService termService;

    @Autowired
    public HtmlTermController(TermService termService) {
        this.termService = termService;
    }

    @GetMapping("htmlRegisterForm")
    public String showHtmlRegisterForm() {
        return "registerForm";
    }

    @PostMapping("/htmlRegister")
    public String registerTerm(@RequestParam("term") String term,
            @RequestParam("description") String description) {
        if (termService.registerTerm(term, description)) {
            return "successRegisterForm";
        }
        return "failedRegisterForm";
    }

    // @GetMapping("/htmlTermList")
    // public List<Term> getTermList() {
    // return this.termService.getTermList();
    // }
}

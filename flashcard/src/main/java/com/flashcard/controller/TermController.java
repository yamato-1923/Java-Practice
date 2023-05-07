package com.flashcard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flashcard.entity.Term;
import com.flashcard.service.TermService;

@RestController
public class TermController {

    private final TermService termService;

    @Autowired
    public TermController(TermService termService) {
        this.termService = termService;
    }

    @GetMapping("/register")
    public String registerTerm(@RequestParam("term") String term, @RequestParam("description") String description) {
        if (termService.registerTerm(new Term(term, description))) {
            return "Registration of the term is complete";
        }
        return "Registration of the term is failed";
    }

    @GetMapping("/termList")
    public List<Term> getTermList() {
        return this.termService.getTermList();
    }
}

package com.flashcard.entity;

import java.util.UUID;

import lombok.Getter;

@Getter
public class Term {

    private String Id;
    private String term;
    private String description;

    public Term(String term, String description) {
        this.Id = UUID.randomUUID().toString();
        this.term = term;
        this.description = description;
    }

}

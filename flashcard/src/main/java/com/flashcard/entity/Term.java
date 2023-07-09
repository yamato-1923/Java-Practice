package com.flashcard.entity;

import lombok.Getter;

@Getter
public class Term {

    private String id;
    private String term;
    private String description;

    public Term(String id, String term, String description) {
        this.id = id;
        this.term = term;
        this.description = description;
    }

}

package com.flashcard.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Term {

    private String term;
    private String description;

    public Term(String term, String description) {
        this.term = term;
        this.description = description;
    }

}

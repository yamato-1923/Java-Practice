package com.flashcard.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TermTests {
    @Test
    void getIdTest() {
        Term target = new Term("id", "term", "description");
        String actual = target.getId();
        assertEquals("id", actual);
    }

    @Test
    void getTermTest() {
        Term target = new Term("id", "term", "description");
        String actual = target.getTerm();
        assertEquals("term", actual);
    }

    @Test
    void getDescriptionTest() {
        Term target = new Term("id", "term", "description");
        String actual = target.getDescription();
        assertEquals("description", actual);
    }
}

package com.flashcard.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TermTests {
    @Test
    void getterTest() {
        Term target = new Term("term", "description");
        String actual = target.getTerm();
        assertEquals("term", actual);
    }
}

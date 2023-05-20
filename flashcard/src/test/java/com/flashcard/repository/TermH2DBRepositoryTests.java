package com.flashcard.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.flashcard.entity.Term;

@SpringBootTest
public class TermH2DBRepositoryTests {

    @Autowired
    private TermH2DBRepository target;

    @Test
    public void insertTermTest() {
        Boolean actual = target.insertTerm(new Term("term", "description"));
        assertEquals(true, actual);
    }

    @Test
    public void getTermListTest() {
        Term term = new Term("term", "description");
        target.insertTerm(term);
        List<Term> actual = target.getTermList();
        assertEquals(1, actual.size());
        assertEquals("term", actual.get(0).getTerm());
        assertEquals("description", actual.get(0).getDescription());
    }
}

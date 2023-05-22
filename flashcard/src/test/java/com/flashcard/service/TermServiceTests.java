package com.flashcard.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.flashcard.entity.Term;
import com.flashcard.repository.TermRepositoryIF;

@SpringBootTest
public class TermServiceTests {

    @Mock
    private TermRepositoryIF mockTermRepository;

    @InjectMocks
    private TermService target;

    @Test
    public void registerTerm() {
        when(mockTermRepository.insertTerm(any())).thenReturn(true);
        Boolean actual = target.registerTerm("term", "description");
        assertEquals(true, actual);
    }

    @Test
    public void getTermList() {
        Term term = new Term("id", "term", "description");
        List<Term> expected = new ArrayList<Term>();
        expected.add(term);
        when(mockTermRepository.getTermList()).thenReturn(expected);
        List<Term> actual = target.getTermList();
        assertEquals(1, actual.size());
        assertEquals(term, actual.get(0));
    }
}

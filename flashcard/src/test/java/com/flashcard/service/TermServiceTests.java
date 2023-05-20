package com.flashcard.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.flashcard.entity.Term;
import com.flashcard.repository.TermH2DBRepository;
import com.flashcard.repository.TermRepositoryIF;

@SpringBootTest
public class TermServiceTests {

    @Mock
    private TermRepositoryIF mockTermRepository;

    @InjectMocks
    private TermService target;

    @Test
    public void registerTerm() {
        Term term = new Term("term", "description");
        when(mockTermRepository.insertTerm(term)).thenReturn(true);
        Boolean actual = target.registerTerm(term);
        assertEquals(true, actual);
    }

    @Test
    public void getTermList() {
        Term term = new Term("term", "description");
        List<Term> expected = new ArrayList<Term>();
        expected.add(term);
        when(mockTermRepository.getTermList()).thenReturn(expected);
        target.registerTerm(term);
        List<Term> actual = target.getTermList();
        assertEquals(1, actual.size());
        assertEquals(term, actual.get(0));
    }
}

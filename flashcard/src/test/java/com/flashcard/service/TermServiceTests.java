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
import com.flashcard.repository.TermMemoryRepository;

@SpringBootTest
public class TermServiceTests {

    @Mock
    private TermMemoryRepository mockTermMemoryRepository;

    @InjectMocks
    private TermService target;

    @Test
    public void registerTerm() {
        Term term = new Term("term", "description");
        when(mockTermMemoryRepository.insertTerm(term)).thenReturn(true);
        Boolean actual = target.registerTerm(term);
        assertEquals(true, actual);
    }

    @Test
    public void getTermList() {
        Term term = new Term("term", "description");
        List<Term> expected = new ArrayList<Term>();
        expected.add(term);
        when(mockTermMemoryRepository.getTermList()).thenReturn(expected);
        target.registerTerm(term);
        List<Term> actual = target.getTermList();
        assertEquals(1, actual.size());
        assertEquals(term, actual.get(0));
    }
}

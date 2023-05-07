package com.flashcard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flashcard.entity.Term;
import com.flashcard.repository.TermMemoryRepository;

@Service
public class TermService {

    private final TermMemoryRepository termMemoryRepository;

    @Autowired
    public TermService(TermMemoryRepository termMemoryRepository) {
        this.termMemoryRepository = termMemoryRepository;
    }

    public Boolean registerTerm(Term term) {
        return termMemoryRepository.insertTerm(term);
    }

    public List<Term> getTermList() {
        return termMemoryRepository.getTermList();
    }
}

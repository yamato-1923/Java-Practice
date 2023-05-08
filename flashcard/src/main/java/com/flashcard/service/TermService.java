package com.flashcard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flashcard.entity.Term;
import com.flashcard.repository.TermRepositoryIF;

@Service
public class TermService {

    private final TermRepositoryIF termRepository;

    @Autowired
    public TermService(TermRepositoryIF termRepository) {
        this.termRepository = termRepository;
    }

    public Boolean registerTerm(Term term) {
        return termRepository.insertTerm(term);
    }

    public List<Term> getTermList() {
        return termRepository.getTermList();
    }
}

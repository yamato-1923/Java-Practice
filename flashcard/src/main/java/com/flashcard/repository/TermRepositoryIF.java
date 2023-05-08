package com.flashcard.repository;

import java.util.List;

import com.flashcard.entity.Term;

public interface TermRepositoryIF {

    public Boolean insertTerm(Term term);

    public List<Term> getTermList();
}

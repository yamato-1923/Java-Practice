package com.flashcard.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.flashcard.entity.Term;

@Repository
public class TermMemoryRepository implements TermRepositoryIF {
    private List<Term> termList = new ArrayList<Term>();

    public Boolean insertTerm(Term term) {
        return termList.add(term);
    }

    public List<Term> getTermList() {
        return this.termList;
    }
}

package com.flashcard.service;

import java.util.List;
import java.util.UUID;

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

    // TODO: ここでTermインスタンスを生成する、ID生成もこのクラスでやる
    public Boolean registerTerm(String term, String description) {
        return termRepository.insertTerm(new Term(UUID.randomUUID().toString(), term, description));
    }

    public List<Term> getTermList() {
        return termRepository.getTermList();
    }
}

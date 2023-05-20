package com.flashcard.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.flashcard.entity.Term;

@Repository
public class TermH2DBRepository implements TermRepositoryIF {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TermH2DBRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Boolean insertTerm(Term term) {
        int rowNumber = jdbcTemplate.update(
                "INSERT INTO TERM(TERM,DESCRIPTION) VALUES(?,?)", term.getTerm(), term.getDescription());
        return rowNumber == 1;
    }

    public List<Term> getTermList() {
        List<Map<String, Object>> mapResult = jdbcTemplate.queryForList("SELECT * FROM TERM");
        List<Term> result = new ArrayList<Term>();
        for (Map<String, Object> map : mapResult) {
            Term term = new Term(map.get("term").toString(), map.get("description").toString());
            result.add(term);
        }
        return result;
    }

}

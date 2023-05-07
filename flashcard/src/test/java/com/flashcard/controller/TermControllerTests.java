package com.flashcard.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.flashcard.entity.Term;
import com.flashcard.service.TermService;

@WebMvcTest(TermController.class)
public class TermControllerTests {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private TermService mockTermService;

        @Test
        @DisplayName("単語を登録できることの確認")
        public void registerTermCompleteTest() throws Exception {
                when(mockTermService.registerTerm(any())).thenReturn(true);
                mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/register")
                                .param("term", "term")
                                .param("description", "description"))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.content().string("Registration of the term is complete"));
        }

        @Test
        @DisplayName("単語を登録できなかったときの確認")
        public void registerTermFailedTest() throws Exception {
                when(mockTermService.registerTerm(any())).thenReturn(false);
                mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/register")
                                .param("term", "term")
                                .param("description", "description"))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.content().string("Registration of the term is failed"));
        }

        @Test
        @DisplayName("単語の一覧を取得")
        public void getTermListTest() throws Exception {
                List<Term> expected = new ArrayList<Term>();
                Term term = new Term("term", "description");
                expected.add(term);
                when(mockTermService.getTermList()).thenReturn(expected);
                mockMvc.perform(
                                MockMvcRequestBuilders
                                                .get("/termList"))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(MockMvcResultMatchers.content()
                                                .string("[{\"term\":\"term\",\"description\":\"description\"}]"));
        }

}

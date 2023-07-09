package com.flashcard.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flashcard.entity.Term;
import com.flashcard.service.TermService;

@WebMvcTest(HtmlTermController.class)
public class HtmlTermControllerTests {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private TermService mockTermService;

        @Test
        @DisplayName("単語の登録ページが表示されることの確認")
        public void showHtmlRegisterFormTest() throws Exception {
                mockMvc.perform(
                                MockMvcRequestBuilders
                                                .get("/htmlRegisterForm"))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(MockMvcResultMatchers.view().name("registerForm"));
        }

        @Test
        @DisplayName("単語登録成功時に成功ページが表示されることの確認")
        public void registerTermSuccessTest() throws Exception {
                when(mockTermService.registerTerm("term", "description")).thenReturn(true);
                mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/htmlRegister")
                                .param("term", "term")
                                .param("description", "description"))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.view().name("successRegisterForm"));
        }

        @Test
        @DisplayName("単語登録失敗時に失敗ページが表示されることの確認")
        public void registerTermFailedTest() throws Exception {
                when(mockTermService.registerTerm("term", "description")).thenReturn(false);
                mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/htmlRegister")
                                .param("term", "term")
                                .param("description", "description"))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.view().name("failedRegisterForm"));
        }

        @Test
        @DisplayName("単語一覧ページが表示されることの確認")
        public void termListTest() throws Exception {
                List<Term> termList = new ArrayList<Term>();
                termList.add(new Term("id", "term", "description"));
                when(mockTermService.getTermList()).thenReturn(termList);
                mockMvc.perform(
                                MockMvcRequestBuilders
                                                .get("/htmlTermList"))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(MockMvcResultMatchers.view().name("termList"))
                                .andExpect(MockMvcResultMatchers.model().attribute("termList", termList));
        }

}

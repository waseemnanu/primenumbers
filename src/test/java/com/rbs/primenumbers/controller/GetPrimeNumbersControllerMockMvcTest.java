package com.rbs.primenumbers.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GetPrimeNumbersControllerMockMvcTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getBadRequest() {
        try {
            this.mockMvc.perform(get("/primenumbers/abc")).andDo(print()).andExpect(status().isBadRequest());
        } catch (Exception e) {
            Assertions.fail();
        }
    }

    @Test
    void getSuccessResponse() {
        try {
            this.mockMvc.perform(get("/primenumbers/12")).andDo(print()).andExpect(status().isOk());
        } catch (Exception e) {
            Assertions.fail();
        }
    }
}

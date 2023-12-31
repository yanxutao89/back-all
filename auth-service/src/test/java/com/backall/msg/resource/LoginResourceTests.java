package com.backall.msg.resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginResourceTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void loginWhenUnAuthenticatedThenRedirect() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void loginSuccessAndFailureWhenAuthenticatedThenRedirect() throws Exception {
        mockMvc.perform(get("/login/success"))
                .andExpect(status().isOk());
        mockMvc.perform(get("/login/failure"))
                .andExpect(status().isOk());
    }

}

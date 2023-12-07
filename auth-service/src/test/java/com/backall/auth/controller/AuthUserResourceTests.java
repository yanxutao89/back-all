package com.backall.auth.controller;

import com.alibaba.fastjson2.JSON;
import com.backall.auth.application.dto.AuthUserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthUserResourceTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCreateConflictUser() throws Exception {
        AuthUserDTO dto = new AuthUserDTO();
        String username = UUID.randomUUID().toString();
        dto.setUsername(username);
        dto.setPassword(UUID.randomUUID().toString());
        mockMvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(dto)))
                        .andExpect(status().isOk());
        mockMvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(dto)))
                        .andExpect(status().isBadRequest());
    }

}

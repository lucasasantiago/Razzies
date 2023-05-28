package com.texoit.razzies.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.texoit.razzies.model.response.AwardRangeResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.core.io.Resource;

import java.net.URL;
import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class AwardControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Value("classpath:data/award-producers-response1.json")
    Resource resourceFile;

    @Test
    public void givenMoviesAwards_whenGetAwardMovieList_thenStatus200()
            throws Exception {

        String expectedResponseContent = new String(resourceFile.getInputStream().readAllBytes(), StandardCharsets.UTF_8);

        mvc.perform(get("/v1/a")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponseContent));
    }
}

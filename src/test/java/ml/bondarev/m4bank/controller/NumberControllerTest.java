package ml.bondarev.m4bank.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class NumberControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void addNumber() throws Exception {
        MvcResult result = this.mockMvc.perform(post("/api/add?name=test1&value=2").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn();

        String res = result.getResponse().getContentAsString();
        assertEquals(res, "{\"code\":0,\"description\":\"OK\"}");

        result = this.mockMvc.perform(post("/api/add?name=test2&value=2").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn();

        res = result.getResponse().getContentAsString();
        assertEquals(res, "{\"code\":0,\"description\":\"OK\"}");
    }

    @Test
    public void getSumNumber() throws Exception {
        MvcResult result = this.mockMvc.perform(post("/api/sum?name1=test1&name2=test2").accept(MediaType.parseMediaType("application/json")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn();

        String res = result.getResponse().getContentAsString();
        System.out.println(res);
        assertEquals(res, "{\"sum\":4,\"code\":0,\"description\":\"OK\"}");
    }

    @Test
    public void removeNumber() throws Exception {
        MvcResult result = this.mockMvc.perform(post("/api/remove?name=Test").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn();

        String res = result.getResponse().getContentAsString();
        assertEquals(res, "{\"code\":0,\"description\":\"OK\"}");
    }
}
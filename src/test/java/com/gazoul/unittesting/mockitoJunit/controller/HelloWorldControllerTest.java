package com.gazoul.unittesting.mockitoJunit.controller;


import com.gazoul.unittesting.mockitoJunit.controller.HelloWorldController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Test
    public void HelloWorldControllerTest() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders //
                .get("/hello-world")        //          Perform a Get call 
                .accept(MediaType.APPLICATION_JSON);    //

        MvcResult result = mockMvc.perform(request)         //
                .andExpect(status().isOk())                 //   Verification of the response
                .andExpect(content().string("Hello World")) //
                .andReturn();                               //

    }
}

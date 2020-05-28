package com.gazoul.unittesting.mockitoJunit;


import com.gazoul.unittesting.mockitoJunit.controller.HelloWorldController;
import com.gazoul.unittesting.mockitoJunit.controller.ItemController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
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
@WebMvcTest(value = ItemController.class)
public class ItemControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Test
    public void dummyItem() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders //
                .get("/dummy-item")        //          Perform a Get call
                .accept(MediaType.APPLICATION_JSON);    //

        MvcResult result = mockMvc.perform(request)         //
                .andExpect(status().isOk())                 //   Verification of the response
                .andExpect(content().string("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":50}")) // specific check each word by word
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10}")) // we can add in space or remove some key pairs ... and it will automatically know and
                .andReturn();                               //

          //JSONAssert.assertEquals(expected, actual, strict);
    }



}

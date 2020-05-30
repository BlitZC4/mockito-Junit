package com.gazoul.unittesting.mockitoJunit.controller;


import com.gazoul.unittesting.mockitoJunit.business.ItemBusinessService;
import com.gazoul.unittesting.mockitoJunit.controller.HelloWorldController;
import com.gazoul.unittesting.mockitoJunit.controller.ItemController;
import com.gazoul.unittesting.mockitoJunit.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ItemController.class)
public class ItemControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ItemBusinessService businessService;

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
    @Test
    public void itemFromBusinessService() throws Exception {
        when(businessService.retrieveHardcodedItem()).thenReturn(
                new Item(2, "Item2", 10, 10));
        RequestBuilder request = MockMvcRequestBuilders //
                .get("/items-from-business-service")        //          Perform a Get call
                .accept(MediaType.APPLICATION_JSON);    //

        MvcResult result = mockMvc.perform(request)         //
                .andExpect(status().isOk())                 //   Verification of the response
                .andExpect(content().json("{id:2,name:Item2,price:10}")) // we can add in space or remove some key pairs ... and it will automatically know and
                .andReturn();                               //
    }

    @Test
    public void itemFromDataService() throws Exception {
        when(businessService.retrieveAllItems()).thenReturn(
                Arrays.asList(
                        new Item(2, "Item2", 10, 10),
                        new Item(3, "Item3", 20, 100),
                        new Item(4, "Item4", 30, 200))
        );
        RequestBuilder request = MockMvcRequestBuilders //
                .get("/all-items-from-database")        //          Perform a Get call
                .accept(MediaType.APPLICATION_JSON);    //

        MvcResult result = mockMvc.perform(request)         //
                .andExpect(status().isOk())                 //   Verification of the response
                .andExpect(content().json("[{id:2,name:Item2,price:10}," +
                        "{id:3,name:Item3,price:20}," +
                        "{id:4,name:Item4,price:30}]")) // we can pass in empty arrays aswell but the count should match like
                .andReturn();                               // we can pass 1 array and add [],[] empty array it will still pass
    }

    /*
            RequestBuilder request = MockMvcRequestBuilders //
                .post("/hello-world")        //          Perform a Post call
                .accept(MediaType.APPLICATION_JSON)
                .content("[{id:2,name:Item2,price:10}," +
                        "{id:3,name:Item3,price:20}," +
                        "{id:4,name:Item4,price:30}]")
                        .contentType(MediaType.APPLICATION_JSON);//

        MvcResult result = mockMvc.perform(request)         //
                .andExpect(status().isCreated())                 //   Verification of the response
                .andExpect(header().string("location",containsString("item")) //
                .andReturn();                               //
*/
}

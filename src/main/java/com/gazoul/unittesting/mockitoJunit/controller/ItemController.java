package com.gazoul.unittesting.mockitoJunit.controller;

import com.gazoul.unittesting.mockitoJunit.business.ItemBusinessService;
import com.gazoul.unittesting.mockitoJunit.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService businessService;

    @GetMapping("/dummy-item")
    public Item dummyItem(){
        return new Item(1, "Ball", 10 , 50);
    }

    @GetMapping("/items-from-business-service")
    public Item itemFromBusinessService(){
        return businessService.retrieveHardcodedItem();
    }
}

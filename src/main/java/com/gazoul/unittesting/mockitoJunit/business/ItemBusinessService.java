package com.gazoul.unittesting.mockitoJunit.business;

import com.gazoul.unittesting.mockitoJunit.data.ItemRepository;
import com.gazoul.unittesting.mockitoJunit.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessService {

    @Autowired
    private ItemRepository itemRepository;

    public Item retrieveHardcodedItem() {
        return new Item(1, "Ball", 10 , 100);
    }

    public List<Item> retrieveAllItems(){
        List<Item> items = itemRepository.findAll();
        for(Item item: items){
            item.setValue(item.getPrice()*item.getQuantity());
        }
        return items;
    }
}

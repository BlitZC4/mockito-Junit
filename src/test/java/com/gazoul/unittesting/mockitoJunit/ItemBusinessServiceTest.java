package com.gazoul.unittesting.mockitoJunit;

import com.gazoul.unittesting.mockitoJunit.business.ItemBusinessService;
import com.gazoul.unittesting.mockitoJunit.data.ItemRepository;
import com.gazoul.unittesting.mockitoJunit.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService itemBusinessService;

    @Mock
    private ItemRepository repository;

    @Test
    public void retrieveAllItemsTest() {
        when(repository.findAll()).thenReturn(Arrays.asList(
                new Item(2, "Item2", 10, 10),
                new Item(3, "Item3", 20, 100),
                new Item(4, "Item4", 30, 200)));

        List<Item> items = itemBusinessService.retrieveAllItems();
        assertEquals(100, items.get(0).getValue());
        assertEquals(2000, items.get(1).getValue());
    }
}
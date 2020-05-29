package com.gazoul.unittesting.mockitoJunit;

import com.gazoul.unittesting.mockitoJunit.data.ItemRepository;
import com.gazoul.unittesting.mockitoJunit.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository repository;

    @Test
    public void testFindAll(){
        List<Item> all = repository.findAll();
        assertEquals(3,all.size());
    }
}

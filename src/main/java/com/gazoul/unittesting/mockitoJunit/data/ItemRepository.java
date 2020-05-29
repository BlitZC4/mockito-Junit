package com.gazoul.unittesting.mockitoJunit.data;

import com.gazoul.unittesting.mockitoJunit.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer>{
}

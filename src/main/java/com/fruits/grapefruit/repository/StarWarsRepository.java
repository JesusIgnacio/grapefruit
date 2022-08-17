package com.fruits.grapefruit.repository;

import com.fruits.grapefruit.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StarWarsRepository extends CrudRepository<Item, Long> {

    List<Item> findAllByName(String word);
}

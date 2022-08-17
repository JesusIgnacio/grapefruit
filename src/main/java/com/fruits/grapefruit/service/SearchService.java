package com.fruits.grapefruit.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fruits.grapefruit.client.ApiClient;
import com.fruits.grapefruit.dto.ItemDTO;
import com.fruits.grapefruit.model.Item;
import com.fruits.grapefruit.repository.StarWarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SearchService {

    @Autowired
    private ApiClient apiClient;
    @Autowired private StarWarsRepository starWarsRepository;
    @Autowired private ObjectMapper mapper;

    @Cacheable(value = "itemCache",
            key = "{#word}", unless="#result == null")
    public Optional<List<ItemDTO>> getListBy(String word) {
        return apiClient.findBy(word)
                .or(() -> findAllByName(word));
    }

    private Optional<List<ItemDTO>> findAllByName(String word) {
        List<Item> items = starWarsRepository.findAllByName(word);
        if (items.isEmpty()) return Optional.empty();
        List<ItemDTO> itemDTOS = new ArrayList<>();
        items.forEach(item -> itemDTOS.add(mapper.convertValue(item, ItemDTO.class)));
        return Optional.ofNullable(itemDTOS);
    }
}

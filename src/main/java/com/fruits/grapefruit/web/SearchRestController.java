package com.fruits.grapefruit.web;

import com.fruits.grapefruit.dto.ItemDTO;
import com.fruits.grapefruit.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController("/finder")
public class SearchRestController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/")
    public ResponseEntity<List<ItemDTO>> searching(@RequestParam String word) {
        Long start = System.currentTimeMillis();
        Optional<List<ItemDTO>> results = searchService.getListBy(word);
        System.out.println("Searching for " + (System.currentTimeMillis() - start) + " ms");
        return ResponseEntity.of(results);
    }
}

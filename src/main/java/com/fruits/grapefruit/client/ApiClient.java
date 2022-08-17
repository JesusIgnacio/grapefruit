package com.fruits.grapefruit.client;

import com.fruits.grapefruit.dto.ItemDTO;
import com.fruits.grapefruit.dto.ResultsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class ApiClient {

    @Autowired
    private RestTemplate restTemplate;
    static final String API_URL = "https://swapi.dev/api/people";

    public Optional<List<ItemDTO>> findBy(String word) {
        ResponseEntity<ResultsDTO> responseEntity = restTemplate
                .getForEntity(API_URL.concat("?search=").concat(word), ResultsDTO.class);
        if (Objects.requireNonNull(responseEntity.getBody()).getResults().isEmpty())
            return Optional.empty();
        return Optional.of(Objects.requireNonNull(responseEntity.getBody()).getResults());
    }
}

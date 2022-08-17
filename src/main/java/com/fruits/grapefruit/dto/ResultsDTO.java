package com.fruits.grapefruit.dto;

import com.fruits.grapefruit.dto.ItemDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ResultsDTO {
    private List<ItemDTO> results ;
}

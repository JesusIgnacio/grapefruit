package com.fruits.grapefruit.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String height;
}
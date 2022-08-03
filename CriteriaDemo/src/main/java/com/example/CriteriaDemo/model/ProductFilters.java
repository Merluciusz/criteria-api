package com.example.CriteriaDemo.model;

import lombok.Getter;

@Getter
public class ProductFilters {
    private final String brand;
    private final String category;
    private final String os;
    private final Double price;

    public ProductFilters(String brand, String category, String os, Double price) {
        this.brand = brand;
        this.category = category;
        this.os = os;
        this.price = price;
    }
}

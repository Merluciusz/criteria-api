package com.example.CriteriaDemo.controllers;

import com.example.CriteriaDemo.model.ProductFilters;
import com.example.CriteriaDemo.model.entities.Product;
import com.example.CriteriaDemo.service.ProductService;
import com.example.CriteriaDemo.service.ProductServiceWithCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private  final ProductServiceWithCriteria productServiceWithCriteria;

    @GetMapping("/method-queries")
    public List<Product> getProducts(@RequestParam(required = false) String brand,
                                     @RequestParam(required = false) String category,
                                     @RequestParam(required = false) String os,
                                     @RequestParam(required = false) Double price) {
        return productService.getProducts(brand, category, os, price);
    }


    @GetMapping("/all")
    public List<Product> getAllProductsWithCriteria(ProductFilters productFilters) {
        return productServiceWithCriteria.getProducts(productFilters);
    }
}

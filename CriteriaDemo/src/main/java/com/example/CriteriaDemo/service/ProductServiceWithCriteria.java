package com.example.CriteriaDemo.service;

import com.example.CriteriaDemo.model.ProductFilters;
import com.example.CriteriaDemo.model.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceWithCriteria {

    private final ProductDAO productDAO;

    public List<Product> getProducts(ProductFilters filters) {
        return productDAO.getAll(filters);
    }
}

package com.example.CriteriaDemo.service;

import com.example.CriteriaDemo.model.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProducts(String brand, String category, String os, Double price) {
        if (brand == null && category == null && os == null && price == null) {
           return productRepository.findAll();
        }

        if (category == null && os == null && price == null) {
            return productRepository.findByBrand(brand);
        }

        if (brand == null && os == null && price == null) {
            return productRepository.findByCategory(category);
        }

        if (brand == null && category == null && price == null) {
            return productRepository.findByOs(os);
        }

        if (brand == null && category == null && os == null) {
            return productRepository.findByPriceLessThanEqual(price);
        }

        if (os == null && price == null) {
            return productRepository.findByBrandAndCategory(brand, category);
        }

        if (category == null && price == null) {
            return productRepository.findByBrandAndOs(brand, os);
        }

        if (os == null && category == null) {
            return productRepository.findByBrandAndPriceLessThanEqual(brand, price);
        }

        if (brand == null && price == null) {
            return productRepository.findByCategoryAndOs(category, os);
        }

        if (brand == null && os == null) {
            return productRepository.findByCategoryAndPriceLessThanEqual(category, price);
        }

        if (brand == null && category == null) {
            return productRepository.findByOsAndPriceLessThanEqual(os, price);
        }

        if (price == null) {
            return productRepository.findByBrandAndCategoryAndOs(brand, category, os);
        }

        if (os == null) {
            return productRepository.findByBrandAndCategoryAndPriceLessThanEqual(brand, category, price);
        }

        if (category == null) {
            return productRepository.findByBrandAndOsAndPriceLessThanEqual(brand, os, price);
        }

        if (brand == null) {
            return productRepository.findByCategoryAndOsAndPriceLessThanEqual(category, os, price);
        }

        return productRepository.findByBrandAndCategoryAndOsAndPriceLessThanEqual(brand, category, os, price);
    }


}

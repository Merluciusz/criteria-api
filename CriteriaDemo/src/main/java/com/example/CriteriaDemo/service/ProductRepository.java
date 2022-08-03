package com.example.CriteriaDemo.service;

import com.example.CriteriaDemo.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//brand category os price
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByBrand(String brand);

    List<Product> findByCategory(String category);

    List<Product> findByOs(String os);

    List<Product> findByPriceLessThanEqual(Double price);

    List<Product> findByBrandAndCategory(String brand, String category);

    List<Product> findByBrandAndOs(String brand, String os);

    List<Product> findByBrandAndPriceLessThanEqual(String brand, Double price);

    List<Product> findByCategoryAndOs(String category, String os);

    List<Product> findByCategoryAndPriceLessThanEqual(String category, Double price);

    List<Product> findByOsAndPriceLessThanEqual(String os, Double price);

    List<Product> findByBrandAndCategoryAndOs(String brand, String category, String os);

    List<Product> findByBrandAndCategoryAndPriceLessThanEqual(String brand, String category, Double price);

    List<Product> findByBrandAndOsAndPriceLessThanEqual(String brand, String os, Double price);

    List<Product> findByCategoryAndOsAndPriceLessThanEqual(String category,String os, Double price);

    List<Product> findByBrandAndCategoryAndOsAndPriceLessThanEqual(String brand, String category, String os, Double price);













    /*


     */


}

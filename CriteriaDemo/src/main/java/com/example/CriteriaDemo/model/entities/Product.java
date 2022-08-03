package com.example.CriteriaDemo.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "brand")
    private String brand; // Asus

    @Column(name = "model")
    private String model;// Jaf-5000-scump

    @Column(name = "description")
    private String description;// Overpriced laptop

    @Column(name = "category")
    private String category;// Business, Gaming, Home, Ultraportabil

    @Column(name = "price")
    private Double price;

    @Column(name = "os")
    private String os;

    @Column(name = "chipset_video")
    private String chipsetVideo;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Review> reviews;

}
//    private Boolean onSale;
//    @Column(name = "on_sale")
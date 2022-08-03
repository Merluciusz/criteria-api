package com.example.CriteriaDemo.model.entities;

import lombok.*;

import javax.persistence.*;

@Table(name = "review")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "feedback")
    private String feedback;

    @Column(name = "rating")
    private Integer rating;
}
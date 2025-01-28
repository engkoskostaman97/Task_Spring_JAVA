package com.belajar.jwt.belajar.jwt.model;
import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private Integer price;
    private String description;
    private Integer stock;
    private Double rating;
    private String imageUrl;

}

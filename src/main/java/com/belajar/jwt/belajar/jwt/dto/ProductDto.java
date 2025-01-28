package com.belajar.jwt.belajar.jwt.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String brand;
    private Integer price;
    private String description;
    private Integer stock;
    private Double rating;
    private String imageUrl;
}

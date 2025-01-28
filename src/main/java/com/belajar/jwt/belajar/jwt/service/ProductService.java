package com.belajar.jwt.belajar.jwt.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belajar.jwt.belajar.jwt.dto.ProductDto;
import com.belajar.jwt.belajar.jwt.model.Product;
import com.belajar.jwt.belajar.jwt.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setBrand(productDto.getBrand());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setStock(productDto.getStock());
        product.setRating(productDto.getRating());
        product.setImageUrl(productDto.getImageUrl());
        return productRepository.save(product);
    }
}
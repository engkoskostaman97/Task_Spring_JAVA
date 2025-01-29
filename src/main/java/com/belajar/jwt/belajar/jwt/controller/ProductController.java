package com.belajar.jwt.belajar.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.belajar.jwt.belajar.jwt.dto.ProductDto;
import com.belajar.jwt.belajar.jwt.model.Product;
import com.belajar.jwt.belajar.jwt.service.AuthService;
import com.belajar.jwt.belajar.jwt.service.ProductService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private AuthService authService;

    // Get all products
    @GetMapping("/list-product")
    public ResponseEntity<List<Product>> getAllProducts(@RequestHeader("Authorization") String token) {
        // Verify JWT token
        try {
            authService.extractClaims(token);
        } catch (Exception e) {
            return ResponseEntity.status(403).build();
        }

        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // Get product by id
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        // Verify JWT token
        try {
            authService.extractClaims(token); 
        } catch (Exception e) {
            return ResponseEntity.status(403).build();
        }

        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    // Post a new product
    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(
        @RequestParam("imageUrl") MultipartFile file,
        @RequestParam("name") String name, 
        @RequestParam("brand") String brand,
        @RequestParam("price") Integer price, 
        @RequestParam("description") String description,
        @RequestParam("stock") Integer stock,
        @RequestParam("rating") Double rating,
        @RequestHeader("Authorization") String token) {

    // Verify JWT token
    try {
        authService.extractClaims(token); 
    } catch (Exception e) {
        return ResponseEntity.status(403).build(); 
    }

    // Save image and get the public URL
    String imageUrl = saveImage(file);

    // Create product DTO
    ProductDto productDto = new ProductDto();
    productDto.setName(name);
    productDto.setBrand(brand);
    productDto.setPrice(price); 
    productDto.setDescription(description);
    productDto.setStock(stock);
    productDto.setRating(rating);
    productDto.setImageUrl(imageUrl);

    // Convert ProductDto to Product entity
    Product product = new Product();
    product.setName(productDto.getName());
    product.setBrand(productDto.getBrand());
    product.setPrice(productDto.getPrice());
    product.setDescription(productDto.getDescription());
    product.setStock(productDto.getStock()); 
    product.setRating(productDto.getRating());
    product.setImageUrl(productDto.getImageUrl());

    // Save product to database
    Product savedProduct = productService.createProduct(productDto);
    return ResponseEntity.ok(savedProduct);
    }


    private String saveImage(MultipartFile file) {
    try {
        // Pastikan folder penyimpanan ada
        String uploadDir = "src/main/resources/static/images/";
        Files.createDirectories(Paths.get(uploadDir));

        // Generate nama unik untuk gambar
        String imageName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path path = Paths.get(uploadDir + imageName);
        Files.write(path, file.getBytes());

        // Return URL lengkap yang bisa diakses publik
        return "http://localhost:8084/images/" + imageName;
    } catch (IOException e) {
        throw new RuntimeException("Failed to save image", e);
    }
 }
}
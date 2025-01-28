package com.belajar.jwt.belajar.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.belajar.jwt.belajar.jwt.model.Product;

public interface ProductRepository extends JpaRepository <Product,Long>{

}

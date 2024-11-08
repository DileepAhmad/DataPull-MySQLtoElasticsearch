package com.example.elasticsearch.repo;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.elasticsearch.model.Product;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Date;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
    @Query("SELECT p FROM Product p WHERE p.createdDate > :lastMigrationDate")
    List<Product> findNewProducts(@Param("lastMigrationDate") Date lastMigrationDate);
}

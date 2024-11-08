package com.example.elasticsearch.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.elasticsearch.model.ESProduct;
import com.example.elasticsearch.model.Product;
import com.example.elasticsearch.repo.ESProductRepository;
import com.example.elasticsearch.repo.ProductRepository;

@Service
public class DataMigrationService {

    private static final Logger logger = LoggerFactory.getLogger(DataMigrationService.class);

    @Autowired
    private ProductRepository mysqlRepository;

    @Autowired
    private ESProductRepository esRepository;

    // For demo purposes, we’ll store `lastMigrationDate` in memory.
    private Date lastMigrationDate = new Date(0); // Set to epoch start to migrate all data initially.

    public void migrateData() {
        logger.info("Starting data migration from MySQL to Elasticsearch");

        try {
            // Fetch only products created after last migration
            List<Product> newProducts = mysqlRepository.findNewProducts(lastMigrationDate);
            if (newProducts.isEmpty()) {
                logger.info("No new data to migrate.");
                return;
            }

            logger.info("Fetched {} new products from MySQL", newProducts.size());

            // Migrate each new product to Elasticsearch
            newProducts.forEach(product -> {
                try {
                    ESProduct esProduct = new ESProduct(product.getId().toString(), product.getName(), product.getDescription());
                    esRepository.save(esProduct);
                    logger.info("Successfully migrated product with ID: {}", product.getId());
                } catch (Exception e) {
                    logger.error("Error migrating product with ID: {}", product.getId(), e);
                }
            });

         // Update the last migration date to the latest product's createdDate
            lastMigrationDate = newProducts.stream()
                                           .map(Product::getCreatedDate)
                                           .max(Date::compareTo)
                                           .orElse(lastMigrationDate);

            logger.info("Data migration completed successfully. Last migration date updated to {}", lastMigrationDate);
        } catch (Exception e) {
            logger.error("Error during data migration", e);
        }
    }
}

package com.example.elasticsearch.repo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.elasticsearch.model.ESProduct;

public interface ESProductRepository extends ElasticsearchRepository<ESProduct, String> {}

package com.example.elasticsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.elasticsearch.service.DataMigrationService;

@RestController
@RequestMapping("/api/migrate")
public class DataMigrationController {

    @Autowired
    private DataMigrationService dataMigrationService;

    @GetMapping
    public String migrateData() {
        dataMigrationService.migrateData();
        return "Data migration from MySQL to Elasticsearch completed.";
    }
}

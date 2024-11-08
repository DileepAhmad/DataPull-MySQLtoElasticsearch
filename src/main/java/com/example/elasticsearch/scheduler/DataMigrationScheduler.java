package com.example.elasticsearch.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.elasticsearch.service.DataMigrationService;

@Component
public class DataMigrationScheduler {

    @Autowired
    private DataMigrationService dataMigrationService;

    // Schedule this job to run for every minute
    @Scheduled(cron = "0 * * * * *")
    public void migrateData() {
        dataMigrationService.migrateData();
        System.out.println("Data migration from MySQL to Elasticsearch completed.");
    }
}

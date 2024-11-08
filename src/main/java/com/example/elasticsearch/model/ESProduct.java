package com.example.elasticsearch.model;

import org.springframework.data.elasticsearch.annotations.Document;

import jakarta.persistence.Id;
import lombok.Data;

@Data
@Document(indexName = "products")
public class ESProduct {
    @Id
    private String id;
    private String name;
    private String description;
    
    public ESProduct() {}

    public ESProduct(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
    
}

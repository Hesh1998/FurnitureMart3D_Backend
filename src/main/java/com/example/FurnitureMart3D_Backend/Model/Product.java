package com.example.FurnitureMart3D_Backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document @Data @AllArgsConstructor @NoArgsConstructor
public class Product {
    private int Id;
    private String product_Name;
}

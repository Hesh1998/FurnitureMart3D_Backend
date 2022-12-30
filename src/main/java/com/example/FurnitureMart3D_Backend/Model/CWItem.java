package com.example.FurnitureMart3D_Backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document @Data @AllArgsConstructor @NoArgsConstructor
public class CWItem {
    private int id;
    private int sellerID;
    private int productID;
}

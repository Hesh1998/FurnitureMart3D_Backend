package com.example.FurnitureMart3D_Backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


// Model class for 3d models of items
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "3d_models")
public class Model3D {
    @Id
    private int id;

    private int userId; // Seller id
    private int productId;
    private int clrId; // 3D model for colour 1, 2 or 3

    private String model3d; // 3D Model in base 64 url format
}


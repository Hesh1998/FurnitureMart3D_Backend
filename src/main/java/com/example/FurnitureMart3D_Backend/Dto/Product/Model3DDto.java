package com.example.FurnitureMart3D_Backend.Dto.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Model3DDto {
    private int userId;
    private int productId;
    private int clrId;
}

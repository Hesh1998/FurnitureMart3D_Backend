package com.example.FurnitureMart3D_Backend.Dto.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class UserProductDto {
    private int userId;
    private int productId;
    private String productName;
}

package com.example.FurnitureMart3D_Backend.Dto.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class DeleteProductDto {
    int userId;
    int productId;
}

package com.example.FurnitureMart3D_Backend.Dto.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// Data transfer object used to update, delete a product
@Data @AllArgsConstructor @NoArgsConstructor
public class DeleteProductDto {
    private int userId;
    private int productId;
}

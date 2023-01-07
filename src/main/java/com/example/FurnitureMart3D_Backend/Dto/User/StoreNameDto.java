package com.example.FurnitureMart3D_Backend.Dto.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// Data transfer object used to get all store names
@Data @AllArgsConstructor @NoArgsConstructor
public class StoreNameDto {
    private String storeName;
}

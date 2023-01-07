package com.example.FurnitureMart3D_Backend.Dto.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// Data transfer object used to get all user passwords
@Data @AllArgsConstructor @NoArgsConstructor
public class PasswordDto {
    private String password;
}

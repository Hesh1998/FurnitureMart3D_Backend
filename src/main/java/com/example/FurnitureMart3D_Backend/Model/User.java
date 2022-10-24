package com.example.FurnitureMart3D_Backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user")
public class User {
    // Primary key
    @Id
    private int id;

    // Other attributes - Buyer
    private String username;
    private String email;
    private String password;
    private String accountType;
    private String contactNo;
    private String deliveryAddress;

    // Other attributes - Seller (Initially null, later can extend to Seller)
    private String storeName;
    private String storeAddress;
    private String paymentAccountName;
    private String paymentAccountNo;
    private String paymentAccountBankName;
    private String paymentAccountBankBranchName;
}

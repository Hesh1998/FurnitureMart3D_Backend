package com.example.FurnitureMart3D_Backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

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
    private String dp;
    private String password;
    private String accountType;
    private String contactNo;
    private String deliveryAddress;
    private String buyerDistrict;

    // Other attributes - Seller (Initially null, later can extend to Seller)
    private String storeName;
    private String storeAddress;
    private String storeDistrict;
    private String paymentAccountName;
    private String paymentAccountNo;
    private String paymentAccountBankName;
    private String paymentAccountBankBranchName;

    // product list
    private List<Product> productList = new ArrayList<>();

    public User(int id, String username, String email, String dp, String password, String accountType, String contactNo, String deliveryAddress, String buyerDistrict, String storeName, String storeAddress, String storeDistrict, String paymentAccountName, String paymentAccountNo, String paymentAccountBankName, String paymentAccountBankBranchName) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.dp = dp;
        this.password = password;
        this.accountType = accountType;
        this.contactNo = contactNo;
        this.deliveryAddress = deliveryAddress;
        this.buyerDistrict = buyerDistrict;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.storeDistrict = storeDistrict;
        this.paymentAccountName = paymentAccountName;
        this.paymentAccountNo = paymentAccountNo;
        this.paymentAccountBankName = paymentAccountBankName;
        this.paymentAccountBankBranchName = paymentAccountBankBranchName;
    }
}

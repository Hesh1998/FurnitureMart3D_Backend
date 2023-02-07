package com.example.FurnitureMart3D_Backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


// Model class for orders placed by buyers
@Data @AllArgsConstructor @NoArgsConstructor
@Document(collection = "order")
public class Order {
    @Id
    private int id;

    // Buyer, seller and item ids
    private int buyerId;
    private int sellerId;
    private int itemId;

    // Other item details
    private String itemImg;
    private String itemName;
    private String clr;
    private int orderQuantity;

    // Other buyer details
    private String buyerEmail;
    private String buyerContactNo;
    private String buyerAddress;
    private String buyerDistrict;

    // Delivery and payment details
    private double subTotal;
    private double deliveryCharge;
    private String orderDate;
    private int estimatedArrival;
    private double totalPay;
    private String paymentMethod;
    private String deliveryStatus;

    // Buyer review
    private String buyerReview;
    private int stars;
}

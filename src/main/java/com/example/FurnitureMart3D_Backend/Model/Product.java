package com.example.FurnitureMart3D_Backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document @Data @AllArgsConstructor @NoArgsConstructor
public class Product {
    private int userId;
    private int itemId;
    private String itemName;

    private String living;
    private String dining;
    private String bedroom;
    private String office;
    private String outdoor;
    private String other;

    private String condition;
    private String description;
    private String dimensions;
    private int stockQuantity;
    private double price;
    private double deliveryFee;
    private int arrivalDays;

    private String material;
    private String clr1;
    private String clr1Img;
    private String clr2;
    private String clr2Img;
    private String clr3;
    private String clr3Img;
    private String clr4;
    private String clr4Img;
    private String clr5;
    private String clr5Img;

    private String add1Img;
    private String add2Img;
    private String add3Img;
    private String vid1;
    private String vid2;
}

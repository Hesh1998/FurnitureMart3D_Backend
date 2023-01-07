package com.example.FurnitureMart3D_Backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


// Model class for Cart/Wishlist item
@Document @Data @AllArgsConstructor @NoArgsConstructor
public class CWItem {
    private int id; // Same as cart it (buyer id)
    private int sellerID;
    private int productID;
}

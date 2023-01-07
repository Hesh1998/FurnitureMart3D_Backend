package com.example.FurnitureMart3D_Backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


// Model class for Cart
@Data @AllArgsConstructor @NoArgsConstructor
@Document(collection = "cart")
public class Cart {
    @Id
    private int id; // Same as buyer id

    // Stores the list of cart items
    private List<CWItem> cartList = new ArrayList<>();

    // Constructor used in creating the cart (does not have any cart items)
    public Cart(int id){
        this.id = id;
    }
}

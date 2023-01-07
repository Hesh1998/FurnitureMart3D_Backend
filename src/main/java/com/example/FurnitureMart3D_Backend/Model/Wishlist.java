package com.example.FurnitureMart3D_Backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


// Model class for Wishlist
@Data @AllArgsConstructor @NoArgsConstructor
@Document(collection = "wishlist")
public class Wishlist {
    @Id
    private int id; // Same as buyer id

    // Stores items in the wishlist
    private List<CWItem> wishlistList = new ArrayList<>();

    // Constructor used to create the wishlist (without any items)
    public Wishlist(int id){
        this.id = id;
    }
}

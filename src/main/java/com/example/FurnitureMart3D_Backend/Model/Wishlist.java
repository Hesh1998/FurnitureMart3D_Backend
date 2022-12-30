package com.example.FurnitureMart3D_Backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
@Document(collection = "wishlist")
public class Wishlist {
    @Id
    private int id;

    private List<CWItem> wishlistList = new ArrayList<>();

    public Wishlist(int id){
        this.id = id;
    }
}

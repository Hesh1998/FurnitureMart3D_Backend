package com.example.FurnitureMart3D_Backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
@Document(collection = "cart")
public class Cart {
    @Id
    private int id;

    private List<CWItem> cartList = new ArrayList<>();

    public Cart(int id){
        this.id = id;
    }
}

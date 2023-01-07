package com.example.FurnitureMart3D_Backend.Repository;

import com.example.FurnitureMart3D_Backend.Model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;


// Repository for Cart
public interface CartRepository extends MongoRepository<Cart, Integer> {

}

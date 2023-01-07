package com.example.FurnitureMart3D_Backend.Repository;

import com.example.FurnitureMart3D_Backend.Model.Wishlist;
import org.springframework.data.mongodb.repository.MongoRepository;


// Repository for Wishlist
public interface WishlistRepository extends MongoRepository<Wishlist, Integer> {

}

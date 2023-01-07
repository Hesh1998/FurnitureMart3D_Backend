package com.example.FurnitureMart3D_Backend.Repository;

import com.example.FurnitureMart3D_Backend.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


// Repository for User (buyer or buyer + seller)
public interface UserRepository extends MongoRepository<User, Integer> {
    User findByUsername(String username);
}

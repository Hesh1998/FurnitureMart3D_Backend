package com.example.FurnitureMart3D_Backend.Repository;

import com.example.FurnitureMart3D_Backend.Model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

// Repository for Orders placed by buyers
public interface OrderRepository extends MongoRepository<Order, Integer>{

}

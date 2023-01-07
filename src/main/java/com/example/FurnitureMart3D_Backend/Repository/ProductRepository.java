package com.example.FurnitureMart3D_Backend.Repository;

import com.example.FurnitureMart3D_Backend.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


// Repository for Product added by sellers
public interface ProductRepository extends MongoRepository<Product, Integer> {
}

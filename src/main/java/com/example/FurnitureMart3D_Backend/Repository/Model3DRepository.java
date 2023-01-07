package com.example.FurnitureMart3D_Backend.Repository;

import com.example.FurnitureMart3D_Backend.Model.Model3D;
import org.springframework.data.mongodb.repository.MongoRepository;


// Repository for 3D model for items
public interface Model3DRepository extends MongoRepository<Model3D, Integer> {

}

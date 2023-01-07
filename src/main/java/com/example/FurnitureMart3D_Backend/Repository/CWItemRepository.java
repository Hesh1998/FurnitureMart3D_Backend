package com.example.FurnitureMart3D_Backend.Repository;

import com.example.FurnitureMart3D_Backend.Model.CWItem;
import org.springframework.data.mongodb.repository.MongoRepository;


// Repository for Cart / Wishlist item
public interface CWItemRepository extends MongoRepository<CWItem, Integer> {

}

package com.example.FurnitureMart3D_Backend.Repository;

import com.example.FurnitureMart3D_Backend.Model.CWItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CWItemRepository extends MongoRepository<CWItem, Integer> {

}

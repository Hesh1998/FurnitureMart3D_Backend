package com.example.FurnitureMart3D_Backend.Controller;

import com.example.FurnitureMart3D_Backend.Dto.Product.DeleteProductDto;
import com.example.FurnitureMart3D_Backend.Dto.User.*;
import com.example.FurnitureMart3D_Backend.Model.Model3D;
import com.example.FurnitureMart3D_Backend.Model.Product;
import com.example.FurnitureMart3D_Backend.Model.User;
import com.example.FurnitureMart3D_Backend.Repository.Model3DRepository;
import com.example.FurnitureMart3D_Backend.Repository.ProductRepository;
import com.example.FurnitureMart3D_Backend.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class Model3DController {
    @Autowired
    private Model3DRepository repository;

    @PostMapping("/add3DModel")
    public String Save(@RequestBody Model3D model){
        repository.save(model);
        return "Success";
    }
}

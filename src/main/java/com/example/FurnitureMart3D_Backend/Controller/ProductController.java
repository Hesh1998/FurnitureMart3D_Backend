package com.example.FurnitureMart3D_Backend.Controller;

import com.example.FurnitureMart3D_Backend.Dto.Product.DeleteProductDto;
import com.example.FurnitureMart3D_Backend.Dto.User.*;
import com.example.FurnitureMart3D_Backend.Model.Product;
import com.example.FurnitureMart3D_Backend.Model.User;
import com.example.FurnitureMart3D_Backend.Repository.ProductRepository;
import com.example.FurnitureMart3D_Backend.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private UserRepository repository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping( value = "/getAllProducts" , produces = APPLICATION_JSON_VALUE)
    public List<Product> findAllProducts(){
        List<Product> productList = new ArrayList<>();
        try {
            List<User> userList = repository.findAll();
            for (User user: userList) {
                for(Product product: user.getProductList()){
                    productList.add(product);
                }
            }
        }catch (Exception e){
            System.out.println("Exception in find Usernames in User Controller");
        }
        return productList;
    }
}

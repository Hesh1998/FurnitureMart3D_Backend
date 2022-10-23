package com.example.FurnitureMart3D_Backend.Controller;

import com.example.FurnitureMart3D_Backend.Model.User;
import com.example.FurnitureMart3D_Backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository repository;


    @PostMapping("/registerUserAsBuyer")
    public User Save(@RequestBody User user){
        return repository.save(user);
    }

    /*
    @GetMapping("/books")
    public List<User> getBooks(){
        return repository.findAll();
    }
     */
}

package com.example.FurnitureMart3D_Backend.Controller;

import com.example.FurnitureMart3D_Backend.Model.Order;
import com.example.FurnitureMart3D_Backend.Model.User;
import com.example.FurnitureMart3D_Backend.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;


// Controller class for Order placed by a buyer
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class OrderController {
    @Autowired
    private OrderRepository repository;

    // Adds a new order
    @PostMapping("/addOrder")
    public String addNewOrder(@RequestBody Order order){
        repository.save(order);
        return "Success";
    }
}

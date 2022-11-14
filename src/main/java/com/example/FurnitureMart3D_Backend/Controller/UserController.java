package com.example.FurnitureMart3D_Backend.Controller;

import com.example.FurnitureMart3D_Backend.Dto.User.*;
import com.example.FurnitureMart3D_Backend.Model.Product;
import com.example.FurnitureMart3D_Backend.Model.User;
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
public class UserController {
    @Autowired
    private UserRepository repository;


    @PostMapping("/registerUserAsBuyer")
    public String Save(@RequestBody User user){
        repository.save(user);
        return "Success";
    }

    @GetMapping("/noOfUsers")
    public int getUsers() {
        return (int) repository.count();
    }

    @GetMapping( value = "/getAllUsernames" , produces = APPLICATION_JSON_VALUE)
    public List<UsernameDto> findUserNames(){
        List<UsernameDto> userNameList = new ArrayList<>();
        try {
            List<User> userList = repository.findAll();
            for (User user: userList) {
                userNameList.add(new UsernameDto(user.getUsername()));
            }
        }catch (Exception e){
            System.out.println("Exception in find Usernames in User Controller");
        }
        return userNameList;
    }

    @GetMapping( value = "/getAllUserEmails" , produces = APPLICATION_JSON_VALUE)
    public List<EmailDto> findUserEmails(){
        List<EmailDto> userEmailList = new ArrayList<>();
        try {
            List<User> userList = repository.findAll();
            for (User user: userList) {
                userEmailList.add(new EmailDto(user.getEmail()));
            }
        }catch (Exception e){
            System.out.println("Exception in find Emails in User Controller");
        }
        return userEmailList;
    }

    @GetMapping( value = "/getAllUserPasswords" , produces = APPLICATION_JSON_VALUE)
    public List<PasswordDto> findUserPasswords(){
        List<PasswordDto> userPasswordList = new ArrayList<>();
        try {
            List<User> userList = repository.findAll();
            for (User user: userList) {
                userPasswordList.add(new PasswordDto(user.getPassword()));
            }
        }catch (Exception e){
            System.out.println("Exception in find Passwords in User Controller");
        }
        return userPasswordList;
    }

    @GetMapping( value = "/getAllUserIds" , produces = APPLICATION_JSON_VALUE)
    public List<IdDto> findUserIds(){
        List<IdDto> userIdList = new ArrayList<>();
        try {
            List<User> userList = repository.findAll();
            for (User user: userList) {
                userIdList.add(new IdDto(user.getId()));
            }
        }catch (Exception e){
            System.out.println("Exception in find Ids in User Controller");
        }
        return userIdList;
    }

    // http://localhost:8080/findbyId/1
    @GetMapping(value = "/findbyId/{userID}", produces = APPLICATION_JSON_VALUE)
    public User findById(@PathVariable Integer userID){
        Optional<User> user =repository.findById(userID);
        return user.get();
    }

    @DeleteMapping(value = "/deleteUser/{id}")
    public boolean DeleteById(@PathVariable Integer id){
        boolean response = false;
        try {
            repository.deleteById(id);
            response=true;
        }catch (Exception e){
            System.out.println("Exception in delete by Id controller !!!!");
        }
        return response;
    }

    @GetMapping( value = "/getAllStoreNames" , produces = APPLICATION_JSON_VALUE)
    public List<StoreNameDto> findStoreNames(){
        List<StoreNameDto> storeNameList = new ArrayList<>();
        try {
            List<User> userList = repository.findAll();
            for (User user: userList) {
                storeNameList.add(new StoreNameDto(user.getStoreName()));
            }
        }catch (Exception e){
            System.out.println("Exception in find Store names in User Controller");
        }
        return storeNameList;
    }

    @PostMapping(value = "/addProduct", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE )
    public boolean addProduct(@RequestBody UserProductDto userProductDto){
        boolean response = false;
        try {
            // find user
            Optional<User> existingUser = repository.findById(userProductDto.getUserId());
            // create a product
            Product newProduct = new Product(userProductDto.getProductId(), userProductDto.getProductName());
            // add the product to the user
            existingUser.get().getProductList().add(newProduct);
            // save the user
            repository.save(existingUser.get());
            response = true;
        }catch (Exception e){
            System.out.println("Exception in Adding product controller !!!");
        }
        return response;
    }


    @GetMapping(value = "/findUserProducts/{id}", produces = APPLICATION_JSON_VALUE)
    public List<Product> findUserProducts(@PathVariable Integer id){
        List<Product> productList = new ArrayList<>();
        try {
            Optional<User> existingUser = repository.findById(id);
            for (Product product:existingUser.get().getProductList()) {
                productList.add(new Product(product.getId(), product.getProduct_Name()));
            }
        }catch (Exception e){
            System.out.println("Exception in find user Product list controller !!!!");
        }
        return productList;
    }
}


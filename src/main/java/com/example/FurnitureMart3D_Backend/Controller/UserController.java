package com.example.FurnitureMart3D_Backend.Controller;

import com.example.FurnitureMart3D_Backend.Dto.User.EmailDto;
import com.example.FurnitureMart3D_Backend.Dto.User.PasswordDto;
import com.example.FurnitureMart3D_Backend.Dto.User.UsernameDto;
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

    /*
    @GetMapping("/usersList")
    public List<User> getUsers() {
        return repository.findAll();
    }*/

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

    @GetMapping(value = "/findbyId/{userID}", produces = APPLICATION_JSON_VALUE)
    public User findById(@PathVariable Integer userID){
        Optional<User> user =repository.findById(userID);
        return user.get();
    }
}

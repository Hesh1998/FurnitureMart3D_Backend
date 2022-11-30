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
public class UserController {
    @Autowired
    private UserRepository repository;
    @Autowired
    private ProductRepository productRepository;


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
    public boolean addProduct(@RequestBody Product product){
        boolean response = false;
        try {
            // find user
            Optional<User> existingUser = repository.findById(product.getUserId());
            // create a product
            Product newProduct = new Product(product.getUserId(), product.getItemId(), product.getItemName(), product.getLiving(), product.getDining(), product.getBedroom(), product.getOffice(), product.getOutdoor(), product.getOther(), product.getCondition(), product.getDescription(), product.getDimensions(), product.getStockQuantity(), product.getInOrder(), product.getTotalSold(), product.getPrice(), product.getDeliveryFee(), product.getArrivalDays(), product.getMaterial(), product.getClr1(), product.getClr1Img(), product.getClr2(), product.getClr2Img(), product.getClr3(), product.getClr3Img(), product.getAdd1Img(), product.getAdd2Img(), product.getVid1());
            // add the product to the user
            existingUser.get().getProductList().add(newProduct);
            // save the user
            repository.save(existingUser.get());
            response = true;
        }catch (Exception e){
            System.out.println("Exception in adding product !!!!");
        }
        return response;
    }


    @GetMapping(value = "/findUserProducts/{id}", produces = APPLICATION_JSON_VALUE)
    public List<Product> findUserProducts(@PathVariable Integer id){
        List<Product> productList = new ArrayList<>();
        try {
            Optional<User> existingUser = repository.findById(id);
            for (Product product:existingUser.get().getProductList()) {
                productList.add(new Product(product.getUserId(), product.getItemId(), product.getItemName(), product.getLiving(), product.getDining(), product.getBedroom(), product.getOffice(), product.getOutdoor(), product.getOther(), product.getCondition(), product.getDescription(), product.getDimensions(), product.getStockQuantity(), product.getInOrder(), product.getTotalSold(), product.getPrice(), product.getDeliveryFee(), product.getArrivalDays(), product.getMaterial(), product.getClr1(), product.getClr1Img(), product.getClr2(), product.getClr2Img(), product.getClr3(), product.getClr3Img(), product.getAdd1Img(), product.getAdd2Img(), product.getVid1()));
            }
        }catch (Exception e){
            System.out.println("Exception in find user Product list controller !!!!");
        }
        return productList;
    }

    @DeleteMapping(value = "/deleteProduct", produces = APPLICATION_JSON_VALUE)
    public boolean DeleteProduct(@RequestBody DeleteProductDto deleteProductDto){
        boolean response = false;
        try {
            Optional<User> existingUser = repository.findById(deleteProductDto.getUserId());
            Product deletedProduct = null;
            for ( Product product : existingUser.get().getProductList()) {
                if (product.getItemId() == deleteProductDto.getProductId()){
                    deletedProduct = product;
                }
            }
            existingUser.get().getProductList().remove(deletedProduct); // delete the product in existingUser object
            repository.save(existingUser.get()); // update the existingUser in database
            response = true;
        }catch (Exception e){
            System.out.println("Exception in delete product controller");
            e.printStackTrace();
        }
        return response;
    }

    @PostMapping(value = "/updateProduct", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE )
    public boolean updateProduct(@RequestBody Product product ) {
        boolean response = false;
        Product searchedProduct = null;
        try {
            Optional<User> existingUser = repository.findById(product.getUserId());
            for ( Product product1 : existingUser.get().getProductList()) {
                if (product1.getItemId() == product.getItemId()){
                    searchedProduct = product1;
                }
            }

            // Setting details of the selected product object
            searchedProduct.setItemName(product.getItemName());
            searchedProduct.setLiving(product.getLiving());
            searchedProduct.setDining(product.getDining());
            searchedProduct.setBedroom(product.getBedroom());
            searchedProduct.setOffice(product.getOffice());
            searchedProduct.setOutdoor(product.getOutdoor());
            searchedProduct.setOther(product.getOther());
            searchedProduct.setCondition(product.getCondition());
            searchedProduct.setDescription(product.getDescription());
            searchedProduct.setDimensions(product.getDimensions());
            searchedProduct.setStockQuantity(product.getStockQuantity());
            searchedProduct.setInOrder(product.getInOrder());
            searchedProduct.setTotalSold(product.getTotalSold());
            searchedProduct.setPrice(product.getPrice());
            searchedProduct.setDeliveryFee(product.getDeliveryFee());
            searchedProduct.setArrivalDays(product.getArrivalDays());
            searchedProduct.setMaterial(product.getMaterial());
            searchedProduct.setClr1(product.getClr1());
            searchedProduct.setClr1Img(product.getClr1Img());
            searchedProduct.setClr2(product.getClr2());
            searchedProduct.setClr2Img(product.getClr2Img());
            searchedProduct.setClr3(product.getClr3());
            searchedProduct.setClr3Img(product.getClr3Img());
            searchedProduct.setAdd1Img(product.getAdd1Img());
            searchedProduct.setAdd2Img(product.getAdd2Img());
            searchedProduct.setVid1(product.getVid1());

            // save the user
            repository.save(existingUser.get());

            response = true;
        }catch (Exception e){
            System.out.println("Exception in update product controller");
        }
        return response;
    }

}


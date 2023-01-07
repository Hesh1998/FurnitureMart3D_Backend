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


// Controller class for user (buyer, seller, products)
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserRepository repository;
    @Autowired
    private ProductRepository productRepository;


    // Adds a new user (buyer)
    @PostMapping("/registerUserAsBuyer")
    public String Save(@RequestBody User user){
        repository.save(user);
        return "Success";
    }


    // Gets the number of all registered users (buyers and buyers + sellers)
    @GetMapping("/noOfUsers")
    public int getUsers() {
        return (int) repository.count();
    }


    // Gets all usernames of users
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


    // Gets all emails of users
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


    // Gets all passwords of users
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


    // Gets all user ids
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


    // Gets all user details based on user id
    @GetMapping(value = "/findbyId/{userID}", produces = APPLICATION_JSON_VALUE)
    public User findById(@PathVariable Integer userID){
        Optional<User> user =repository.findById(userID);
        return user.get();
    }


    // Deletes a user
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


    // Gets all store names
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


    // Adds a product
    @PostMapping(value = "/addProduct", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE )
    public boolean addProduct(@RequestBody Product product){
        boolean response = false;
        try {
            // Find user
            Optional<User> existingUser = repository.findById(product.getUserId());
            // Create a product
            Product newProduct = new Product(product.getUserId(), product.getItemId(), product.getItemName(), product.getLiving(), product.getDining(), product.getBedroom(), product.getOffice(), product.getOutdoor(), product.getOther(), product.getChair(), product.getTable(), product.getSofa(), product.getCupboard(), product.getBed(), product.getBench(), product.getBookcase(), product.getDesk(), product.getOtherT(), product.getClassy(), product.getAntique(), product.getTraditional(), product.getModern(), product.getContemporary(), product.getTransitional(), product.getCoastal(), product.getMinimalist(), product.getCondition(), product.getDescription(), product.getDimensions(), product.getStockQuantity(), product.getInOrder(), product.getTotalSold(), product.getPrice(), product.getDeliveryColombo(), product.getArrivalColombo(), product.getDeliveryGampaha(), product.getArrivalGampaha(), product.getDeliveryKalutara(), product.getArrivalKalutara(), product.getDeliveryKandy(), product.getArrivalKandy(), product.getDeliveryMatale(), product.getArrivalMatale(), product.getDeliveryNuwaraEliya(), product.getArrivalNuwaraEliya(), product.getDeliveryGalle(), product.getArrivalGalle(), product.getDeliveryMatara(), product.getArrivalMatara(), product.getDeliveryHambantota(), product.getArrivalHambantota(), product.getDeliveryJaffna(), product.getArrivalJaffna(), product.getDeliveryKilinochchi(), product.getArrivalKilinochchi(), product.getDeliveryMannar(), product.getArrivalMannar(), product.getDeliveryVavuniya(), product.getArrivalVavuniya(), product.getDeliveryMullaitivu(), product.getArrivalMullaitivu(), product.getDeliveryBatticallo(), product.getArrivalBatticallo(), product.getDeliveryAmpara(), product.getArrivalAmpara(), product.getDeliveryTrincomalee(), product.getArrivalTrincomalee(), product.getDeliveryKurunegala(), product.getArrivalKurunegala(), product.getDeliveryPuttalam(), product.getArrivalPuttalam(), product.getDeliveryAnuradhapura(), product.getArrivalAnuradhapura(), product.getDeliveryPolonnaruwa(), product.getArrivalPolonnaruwa(), product.getDeliveryBadulla(), product.getArrivalBadulla(), product.getDeliveryMoneragala(), product.getArrivalMoneragala(), product.getDeliveryRatnapura(), product.getArrivalRatnapura(), product.getDeliveryKegalle(), product.getArrivalKegalle(), product.getMaterial(), product.getMaterialDescription(), product.getSubMaterials(), product.getSubMaterialsDescription(), product.getClr1(), product.getClr1Img(), product.getClr2(), product.getClr2Img(), product.getClr3(), product.getClr3Img(), product.getAdd1Img(), product.getAdd2Img(), product.getVid1());
            // Add the product to the user
            existingUser.get().getProductList().add(newProduct);
            // Save the user
            repository.save(existingUser.get());
            response = true;
        }catch (Exception e){
            System.out.println("Exception in adding product !!!!");
        }
        return response;
    }


    // Gets all products added by a specific seller
    @GetMapping(value = "/findUserProducts/{id}", produces = APPLICATION_JSON_VALUE)
    public List<Product> findUserProducts(@PathVariable Integer id){
        List<Product> productList = new ArrayList<>();
        try {
            Optional<User> existingUser = repository.findById(id);
            for (Product product:existingUser.get().getProductList()) {
                productList.add(new Product(product.getUserId(), product.getItemId(), product.getItemName(), product.getLiving(), product.getDining(), product.getBedroom(), product.getOffice(), product.getOutdoor(), product.getOther(), product.getChair(), product.getTable(), product.getSofa(), product.getCupboard(), product.getBed(), product.getBench(), product.getBookcase(), product.getDesk(), product.getOtherT(), product.getClassy(), product.getAntique(), product.getTraditional(), product.getModern(), product.getContemporary(), product.getTransitional(), product.getCoastal(), product.getMinimalist(), product.getCondition(), product.getDescription(), product.getDimensions(), product.getStockQuantity(), product.getInOrder(), product.getTotalSold(), product.getPrice(), product.getDeliveryColombo(), product.getArrivalColombo(), product.getDeliveryGampaha(), product.getArrivalGampaha(), product.getDeliveryKalutara(), product.getArrivalKalutara(), product.getDeliveryKandy(), product.getArrivalKandy(), product.getDeliveryMatale(), product.getArrivalMatale(), product.getDeliveryNuwaraEliya(), product.getArrivalNuwaraEliya(), product.getDeliveryGalle(), product.getArrivalGalle(), product.getDeliveryMatara(), product.getArrivalMatara(), product.getDeliveryHambantota(), product.getArrivalHambantota(), product.getDeliveryJaffna(), product.getArrivalJaffna(), product.getDeliveryKilinochchi(), product.getArrivalKilinochchi(), product.getDeliveryMannar(), product.getArrivalMannar(), product.getDeliveryVavuniya(), product.getArrivalVavuniya(), product.getDeliveryMullaitivu(), product.getArrivalMullaitivu(), product.getDeliveryBatticallo(), product.getArrivalBatticallo(), product.getDeliveryAmpara(), product.getArrivalAmpara(), product.getDeliveryTrincomalee(), product.getArrivalTrincomalee(), product.getDeliveryKurunegala(), product.getArrivalKurunegala(), product.getDeliveryPuttalam(), product.getArrivalPuttalam(), product.getDeliveryAnuradhapura(), product.getArrivalAnuradhapura(), product.getDeliveryPolonnaruwa(), product.getArrivalPolonnaruwa(), product.getDeliveryBadulla(), product.getArrivalBadulla(), product.getDeliveryMoneragala(), product.getArrivalMoneragala(), product.getDeliveryRatnapura(), product.getArrivalRatnapura(), product.getDeliveryKegalle(), product.getArrivalKegalle(), product.getMaterial(), product.getMaterialDescription(), product.getSubMaterials(), product.getSubMaterialsDescription(), product.getClr1(), product.getClr1Img(), product.getClr2(), product.getClr2Img(), product.getClr3(), product.getClr3Img(), product.getAdd1Img(), product.getAdd2Img(), product.getVid1()));
            }
        }catch (Exception e){
            System.out.println("Exception in find user Product list controller !!!!");
        }
        return productList;
    }


    // Deletes a product
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
            // Delete the product in existingUser object
            existingUser.get().getProductList().remove(deletedProduct);
            // Update the existingUser in database
            repository.save(existingUser.get());
            response = true;
        }catch (Exception e){
            System.out.println("Exception in delete product controller");
            e.printStackTrace();
        }
        return response;
    }


    // Update a product added by a specific seller
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

            searchedProduct.setChair(product.getChair());
            searchedProduct.setTable(product.getTable());
            searchedProduct.setSofa(product.getSofa());
            searchedProduct.setCupboard(product.getCupboard());
            searchedProduct.setBed(product.getBed());
            searchedProduct.setBench(product.getBench());
            searchedProduct.setBookcase(product.getBookcase());
            searchedProduct.setDesk(product.getDesk());
            searchedProduct.setOtherT(product.getOtherT());

            searchedProduct.setClassy(product.getClassy());
            searchedProduct.setAntique(product.getAntique());
            searchedProduct.setTraditional(product.getTraditional());
            searchedProduct.setModern(product.getModern());
            searchedProduct.setContemporary(product.getContemporary());
            searchedProduct.setTransitional(product.getTransitional());
            searchedProduct.setCoastal(product.getCoastal());
            searchedProduct.setMinimalist(product.getMinimalist());

            searchedProduct.setCondition(product.getCondition());
            searchedProduct.setDescription(product.getDescription());
            searchedProduct.setDimensions(product.getDimensions());
            searchedProduct.setStockQuantity(product.getStockQuantity());
            searchedProduct.setInOrder(product.getInOrder());
            searchedProduct.setTotalSold(product.getTotalSold());
            searchedProduct.setPrice(product.getPrice());

            searchedProduct.setDeliveryColombo(product.getDeliveryColombo());
            searchedProduct.setDeliveryGampaha(product.getDeliveryGampaha());
            searchedProduct.setDeliveryKalutara(product.getDeliveryKalutara());
            searchedProduct.setDeliveryKandy(product.getDeliveryKandy());
            searchedProduct.setDeliveryMatale(product.getDeliveryMatale());
            searchedProduct.setDeliveryNuwaraEliya(product.getDeliveryNuwaraEliya());
            searchedProduct.setDeliveryGalle(product.getDeliveryGalle());
            searchedProduct.setDeliveryMatara(product.getDeliveryMatara());
            searchedProduct.setDeliveryHambantota(product.getDeliveryHambantota());
            searchedProduct.setDeliveryJaffna(product.getDeliveryJaffna());
            searchedProduct.setDeliveryKilinochchi(product.getDeliveryKilinochchi());
            searchedProduct.setDeliveryMannar(product.getDeliveryMannar());
            searchedProduct.setDeliveryVavuniya(product.getDeliveryVavuniya());
            searchedProduct.setDeliveryMullaitivu(product.getDeliveryMullaitivu());
            searchedProduct.setDeliveryBatticallo(product.getDeliveryBatticallo());
            searchedProduct.setDeliveryAmpara(product.getDeliveryAmpara());
            searchedProduct.setDeliveryTrincomalee(product.getDeliveryTrincomalee());
            searchedProduct.setDeliveryKurunegala(product.getDeliveryKurunegala());
            searchedProduct.setDeliveryPuttalam(product.getDeliveryPuttalam());
            searchedProduct.setDeliveryAnuradhapura(product.getDeliveryAnuradhapura());
            searchedProduct.setDeliveryPolonnaruwa(product.getDeliveryPolonnaruwa());
            searchedProduct.setDeliveryBadulla(product.getDeliveryBadulla());
            searchedProduct.setDeliveryMoneragala(product.getDeliveryMoneragala());
            searchedProduct.setDeliveryRatnapura(product.getDeliveryRatnapura());
            searchedProduct.setDeliveryKegalle(product.getDeliveryKegalle());

            searchedProduct.setArrivalColombo(product.getArrivalColombo());
            searchedProduct.setArrivalGampaha(product.getArrivalGampaha());
            searchedProduct.setArrivalKalutara(product.getArrivalKalutara());
            searchedProduct.setArrivalKandy(product.getArrivalKandy());
            searchedProduct.setArrivalMatale(product.getArrivalMatale());
            searchedProduct.setArrivalNuwaraEliya(product.getArrivalNuwaraEliya());
            searchedProduct.setArrivalGalle(product.getArrivalGalle());
            searchedProduct.setArrivalMatara(product.getArrivalMatara());
            searchedProduct.setArrivalHambantota(product.getArrivalHambantota());
            searchedProduct.setArrivalJaffna(product.getArrivalJaffna());
            searchedProduct.setArrivalKilinochchi(product.getArrivalKilinochchi());
            searchedProduct.setArrivalMannar(product.getArrivalMannar());
            searchedProduct.setArrivalVavuniya(product.getArrivalVavuniya());
            searchedProduct.setArrivalMullaitivu(product.getArrivalMullaitivu());
            searchedProduct.setArrivalBatticallo(product.getArrivalBatticallo());
            searchedProduct.setArrivalAmpara(product.getArrivalAmpara());
            searchedProduct.setArrivalTrincomalee(product.getArrivalTrincomalee());
            searchedProduct.setArrivalKurunegala(product.getArrivalKurunegala());
            searchedProduct.setArrivalPuttalam(product.getArrivalPuttalam());
            searchedProduct.setArrivalAnuradhapura(product.getArrivalAnuradhapura());
            searchedProduct.setArrivalPolonnaruwa(product.getArrivalPolonnaruwa());
            searchedProduct.setArrivalBadulla(product.getArrivalBadulla());
            searchedProduct.setArrivalMoneragala(product.getArrivalMoneragala());
            searchedProduct.setArrivalRatnapura(product.getArrivalRatnapura());
            searchedProduct.setArrivalKegalle(product.getArrivalKegalle());

            searchedProduct.setMaterial(product.getMaterial());
            searchedProduct.setMaterialDescription(product.getMaterialDescription());
            searchedProduct.setSubMaterials(product.getSubMaterials());
            searchedProduct.setSubMaterialsDescription(product.getSubMaterialsDescription());
            searchedProduct.setClr1(product.getClr1());
            searchedProduct.setClr1Img(product.getClr1Img());
            searchedProduct.setClr2(product.getClr2());
            searchedProduct.setClr2Img(product.getClr2Img());
            searchedProduct.setClr3(product.getClr3());
            searchedProduct.setClr3Img(product.getClr3Img());
            searchedProduct.setAdd1Img(product.getAdd1Img());
            searchedProduct.setAdd2Img(product.getAdd2Img());
            searchedProduct.setVid1(product.getVid1());

            // Save the user
            repository.save(existingUser.get());

            response = true;
        }catch (Exception e){
            System.out.println("Exception in update product controller");
        }
        return response;
    }


    // Gets details related to a specific product
    @GetMapping(value = "/viewProductDetails", produces = APPLICATION_JSON_VALUE)
    public Product viewProductDetails(@RequestBody DeleteProductDto deleteProductDto) {
        Product searchedProduct = null;
        try {
            Optional<User> existingUser = repository.findById(deleteProductDto.getUserId());
            for ( Product product1 : existingUser.get().getProductList()) {
                if (product1.getItemId() == deleteProductDto.getProductId()){
                    searchedProduct = product1;
                }
            }
        }catch (Exception e){
            System.out.println("Exception in update product controller");
        }

        return searchedProduct;
    }

}


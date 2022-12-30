package com.example.FurnitureMart3D_Backend.Controller;

import com.example.FurnitureMart3D_Backend.Model.Cart;
import com.example.FurnitureMart3D_Backend.Model.CWItem;
import com.example.FurnitureMart3D_Backend.Repository.CartRepository;
import com.example.FurnitureMart3D_Backend.Repository.CWItemRepository;
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
public class CartController {
    @Autowired
    private CartRepository repository;
    @Autowired
    private CWItemRepository itemRepository;

    @PostMapping("/createCart")
    public String createCart(@RequestBody Cart cart){
        repository.save(cart);
        return "Success";
    }

    @PostMapping(value = "/addItemToCart", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE )
    public boolean addToCart(@RequestBody CWItem item){
        boolean response = false;
        try {
            // find cart
            Optional<Cart> existingCart = repository.findById(item.getId());
            // create a item
            CWItem newItem = new CWItem(item.getId(), item.getSellerID(), item.getProductID());
            // add the item to cart
            existingCart.get().getCartList().add(newItem);
            // save the cart
            repository.save(existingCart.get());
            response = true;
        }catch (Exception e){
            System.out.println("Exception in adding item to cart!");
        }
        return response;
    }

    @GetMapping(value = "/findCartItems/{id}", produces = APPLICATION_JSON_VALUE)
    public List<CWItem> findCartItems(@PathVariable Integer id){
        List<CWItem> itemList = new ArrayList<>();
        try {
            Optional<Cart> existingCart = repository.findById(id);
            for (CWItem item:existingCart.get().getCartList()) {
                itemList.add(new CWItem(item.getId(), item.getSellerID(), item.getProductID()));
            }
        }catch (Exception e){
            System.out.println("Exception in find cart items !!!!");
        }
        return itemList;
    }

    @DeleteMapping(value = "/deleteCartItem", produces = APPLICATION_JSON_VALUE)
    public boolean deleteCartItem(@RequestBody CWItem deleteItemDetails){
        boolean response = false;
        try {
            Optional<Cart> existingCart = repository.findById(deleteItemDetails.getId());
            CWItem deletedItem = null;
            for ( CWItem item : existingCart.get().getCartList()) {
                if (item.getSellerID() == deleteItemDetails.getSellerID() & item.getProductID() == deleteItemDetails.getProductID()){
                    deletedItem = item;
                }
            }
            existingCart.get().getCartList().remove(deletedItem);
            repository.save(existingCart.get());
            response = true;
        }catch (Exception e){
            System.out.println("Exception in delete cart item controller");
            e.printStackTrace();
        }
        return response;
    }

    @DeleteMapping(value = "/deleteCart/{id}")
    public boolean deleteCart(@PathVariable Integer id){
        boolean response = false;
        try {
            repository.deleteById(id);
            response=true;
        }catch (Exception e){
            System.out.println("Exception in delete cart!");
        }
        return response;
    }
}

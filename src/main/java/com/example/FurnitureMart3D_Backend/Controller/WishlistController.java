package com.example.FurnitureMart3D_Backend.Controller;

import com.example.FurnitureMart3D_Backend.Model.Wishlist;
import com.example.FurnitureMart3D_Backend.Model.CWItem;
import com.example.FurnitureMart3D_Backend.Repository.WishlistRepository;
import com.example.FurnitureMart3D_Backend.Repository.CWItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;


// Controller class for Wishlist
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class WishlistController {
    @Autowired
    private WishlistRepository repository;
    @Autowired
    private CWItemRepository itemRepository;


    // Creates a wishlist when a buyer registers
    @PostMapping("/createWishlist")
    public String createWishlist(@RequestBody Wishlist wishlist){
        repository.save(wishlist);
        return "Success";
    }


    // Adds an item to the wishlist
    @PostMapping(value = "/addItemToWishlist", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE )
    public boolean addToWishlist(@RequestBody CWItem item){
        boolean response = false;
        try {
            // Find wishlist
            Optional<Wishlist> existingWishlist = repository.findById(item.getId());
            // Create a item
            CWItem newItem = new CWItem(item.getId(), item.getSellerID(), item.getProductID());
            // Add the item to wishlist
            existingWishlist.get().getWishlistList().add(newItem);
            // Save the wishlist
            repository.save(existingWishlist.get());
            response = true;
        }catch (Exception e){
            System.out.println("Exception in adding item to wishlist!");
        }
        return response;
    }


    // Gets all items in the wishlist for a specific buyer
    @GetMapping(value = "/findWishlistItems/{id}", produces = APPLICATION_JSON_VALUE)
    public List<CWItem> findWishlistItems(@PathVariable Integer id){
        List<CWItem> itemList = new ArrayList<>();
        try {
            Optional<Wishlist> existingWishlist = repository.findById(id);
            for (CWItem item:existingWishlist.get().getWishlistList()) {
                itemList.add(new CWItem(item.getId(), item.getSellerID(), item.getProductID()));
            }
        }catch (Exception e){
            System.out.println("Exception in find wishlist items !!!!");
        }
        return itemList;
    }


    // Deletes an item in the wishlist
    @DeleteMapping(value = "/deleteWishlistItem", produces = APPLICATION_JSON_VALUE)
    public boolean deleteWishlistItem(@RequestBody CWItem deleteItemDetails){
        boolean response = false;
        try {
            Optional<Wishlist> existingWishlist = repository.findById(deleteItemDetails.getId());
            CWItem deletedItem = null;
            for ( CWItem item : existingWishlist.get().getWishlistList()) {
                if (item.getSellerID() == deleteItemDetails.getSellerID() & item.getProductID() == deleteItemDetails.getProductID()){
                    deletedItem = item;
                }
            }
            existingWishlist.get().getWishlistList().remove(deletedItem);
            repository.save(existingWishlist.get());
            response = true;
        }catch (Exception e){
            System.out.println("Exception in delete cart item controller");
            e.printStackTrace();
        }
        return response;
    }


    // Deletes entire wishlist when a user removes the account
    @DeleteMapping(value = "/deleteWishlist/{id}")
    public boolean deleteWishlist(@PathVariable Integer id){
        boolean response = false;
        try {
            repository.deleteById(id);
            response=true;
        }catch (Exception e){
            System.out.println("Exception in delete wishlist!");
        }
        return response;
    }
}

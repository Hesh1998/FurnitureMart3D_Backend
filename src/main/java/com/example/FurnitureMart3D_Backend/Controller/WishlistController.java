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

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class WishlistController {
    @Autowired
    private WishlistRepository repository;
    @Autowired
    private CWItemRepository itemRepository;

    @PostMapping("/createWishlist")
    public String createWishlist(@RequestBody Wishlist wishlist){
        repository.save(wishlist);
        return "Success";
    }

    @PostMapping(value = "/addItemToWishlist", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE )
    public boolean addToWishlist(@RequestBody CWItem item){
        boolean response = false;
        try {
            // find wishlist
            Optional<Wishlist> existingWishlist = repository.findById(item.getId());
            // create a item
            CWItem newItem = new CWItem(item.getId(), item.getSellerID(), item.getProductID());
            // add the item to wishlist
            existingWishlist.get().getWishlistList().add(newItem);
            // save the wishlist
            repository.save(existingWishlist.get());
            response = true;
        }catch (Exception e){
            System.out.println("Exception in adding item to wishlist!");
        }
        return response;
    }

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

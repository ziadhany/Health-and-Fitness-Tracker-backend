package com.example.librarymanagementbackend.wishlist;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/wish-list")
@PreAuthorize("hasRole('USER')")
public class WishListController {
    private WishListService wishListService;
    @PostMapping
    public ResponseEntity<WishList> addWishList(@RequestBody WishList wishList){
        return  ResponseEntity.ok( wishListService.addWishList(wishList));
    }
    @GetMapping("/{id}")
    public ResponseEntity<WishList> getWishList(@PathVariable Long id){
        return ResponseEntity.ok( wishListService.getWishList(id));
    }
    @PutMapping
    public ResponseEntity<WishList> updateWishList(@RequestBody WishList wishList){
        return ResponseEntity.ok( wishListService.updateWishList(wishList));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteWishList(@PathVariable Long id){
        wishListService.deleteWishList(id);
        return ResponseEntity.ok(true);
    }
}

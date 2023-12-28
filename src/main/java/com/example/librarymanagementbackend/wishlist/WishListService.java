package com.example.librarymanagementbackend.wishlist;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WishListService {
    private WishListRepository wishListRepo;
    public WishList addWishList(WishList wishList){
        return wishListRepo.save(wishList);
    }
    public WishList getWishList(Long id){
        return wishListRepo.findById(id).orElseThrow(()->new RuntimeException("wish list not found"));
    }
    public void deleteWishList(Long id){
        wishListRepo.deleteById(id);
    }
    public WishList updateWishList(WishList wishList){
        WishList oldWishList=wishListRepo.findById(wishList.getId()).orElseThrow(()->new RuntimeException("wish list not found"));
        oldWishList.setBooks(wishList.getBooks());
        return wishListRepo.save(wishList);
    }

}

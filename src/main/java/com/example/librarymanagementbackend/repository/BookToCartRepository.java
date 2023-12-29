package com.example.librarymanagementbackend.repository;

import com.example.librarymanagementbackend.Entity.BookToCart;
import com.example.librarymanagementbackend.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookToCartRepository extends JpaRepository<BookToCart, Integer> {

    List<BookToCart> deleteByCartItem(Cart cartItem);
}


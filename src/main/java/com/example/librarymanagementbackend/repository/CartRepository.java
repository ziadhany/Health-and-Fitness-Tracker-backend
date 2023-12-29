package com.example.librarymanagementbackend.repository;

import com.example.librarymanagementbackend.Entity.Cart;
import com.example.librarymanagementbackend.Entity.ShoppingCart;
import com.example.librarymanagementbackend.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findByShoppingCart(ShoppingCart shoppingCart);
    List<Cart> findByOrder(Order order);
}
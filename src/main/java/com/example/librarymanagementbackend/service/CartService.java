package com.example.librarymanagementbackend.service;

import com.example.librarymanagementbackend.Entity.ShoppingCart;
import com.example.librarymanagementbackend.Entity.Cart;
import com.example.librarymanagementbackend.Entity.Order;
import com.example.librarymanagementbackend.book.Book;
import com.example.librarymanagementbackend.user.User;

import java.util.List;

public interface CartService {

    Cart addToCart(Book book, User user, int quantity);
    List<Cart> findByShoppingCart(ShoppingCart shoppingCart);
    List<Cart> findByOrder(Order order);
    Cart updateCart(Cart cartItem);
    void deleteCart(Cart cartItem);
    Cart findById(int id);
    Cart save(Cart cartItem);
}

package com.example.librarymanagementbackend.service;

import com.example.librarymanagementbackend.Entity.ShoppingCart;


public interface ShoppingCartService {

    ShoppingCart update(ShoppingCart shoppingCart);
    void clear(ShoppingCart shoppingCart);
}


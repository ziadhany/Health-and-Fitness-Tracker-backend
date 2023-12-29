package com.example.librarymanagementbackend.service;

import com.example.librarymanagementbackend.Entity.ShoppingCart;
import com.example.librarymanagementbackend.Entity.Order;
import com.example.librarymanagementbackend.Entity.Cart;
import com.example.librarymanagementbackend.user.User;

import java.util.List;

public interface OrderService {

    Order createOrder(ShoppingCart shoppingCart,
                      User user);

    List<Order> findAllOrders();

    void deleteOrder(Order order);

    Order findById(int id);
}

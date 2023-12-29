package com.example.librarymanagementbackend.service.impl;


import com.example.librarymanagementbackend.Entity.ShoppingCart;
import com.example.librarymanagementbackend.Entity.Order;
import com.example.librarymanagementbackend.Entity.Cart;
import com.example.librarymanagementbackend.book.Book;
import com.example.librarymanagementbackend.book.BookService;
import com.example.librarymanagementbackend.repository.OrderRepository;
import com.example.librarymanagementbackend.service.CartService;
import com.example.librarymanagementbackend.service.OrderService;
import com.example.librarymanagementbackend.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CartService cartService;
    @Autowired
    BookService bookService;

    @Override
    public synchronized Order createOrder(ShoppingCart shoppingCart, User user) {

        Order order = new Order();
        order.setOrderStatus("created");

        List<Cart> cartItemList = cartService.findByShoppingCart(shoppingCart);

        for (Cart cartItem: cartItemList) {
            Book book = cartItem.getBook();
            cartItem.setOrder(order);
            book.setInStockNumber(book.getInStockNumber() - cartItem.getQuantity());
        }

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        order.setCartItemList(cartItemList);
        order.setOrderDate(timeFormatter.format(localDateTime));
        order.setOrderTotal(shoppingCart.getTotal().intValue());
        order.setUser(user);

        order = orderRepository.save(order);

        return order;
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteOrder(Order order) {
        orderRepository.delete(order);
    }

    @Override
    public Order findById(int id) {
        return orderRepository.findById(id).get();
    }

    public Order findOne(int id) {
        return orderRepository.findById(id).get();
    }

}
package com.example.librarymanagementbackend.Controllers;
import com.example.librarymanagementbackend.Entity.Cart;
import com.example.librarymanagementbackend.Entity.Order;
import com.example.librarymanagementbackend.service.CartService;
import com.example.librarymanagementbackend.service.OrderService;
import com.example.librarymanagementbackend.user.User;
import com.example.librarymanagementbackend.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService orderService;

    @RequestMapping("/")
    public List<Order> getUserOrders(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        List<Order> orderList = user.getOrderList();

        return orderList;
    }

    @RequestMapping("/single/{id}")
    public List<Cart> getUserSingleOrder(@RequestBody String orderId, Principal principal) {
        Order order = orderService.findById(Integer.parseInt(orderId));
        List<Cart> cartList = cartService.findByOrder(order);
        return cartList;
    }

    @RequestMapping(value = "/cancel/{id}", method = RequestMethod.POST)
    public ResponseEntity cancelOrder(@RequestBody String id) {
        Order order = orderService.findById(Integer.parseInt(id));
        orderService.deleteOrder(order);
        return new ResponseEntity(HttpStatus.OK);
    }

}
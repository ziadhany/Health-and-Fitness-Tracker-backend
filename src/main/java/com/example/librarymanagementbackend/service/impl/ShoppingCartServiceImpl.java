package com.example.librarymanagementbackend.service.impl;

import com.example.librarymanagementbackend.Entity.Cart;
import com.example.librarymanagementbackend.Entity.ShoppingCart;
import com.example.librarymanagementbackend.repository.ShoppingCartRepository;
import com.example.librarymanagementbackend.service.CartService;
import com.example.librarymanagementbackend.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private CartService cartService;
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Override
    public ShoppingCart update(ShoppingCart shoppingCart) {
        BigDecimal cartTotal = new BigDecimal(0);
        List<Cart> cartItemList = cartService.findByShoppingCart(shoppingCart);

        for (Cart cartItem: cartItemList) {
            if (cartItem.getBook().getInStockNumber() > 0){
                cartService.updateCart(cartItem);
                cartTotal = cartTotal.add(cartItem.getSubTotal());
            }
        }
        shoppingCart.setTotal(cartTotal);
        shoppingCartRepository.save(shoppingCart);
        return shoppingCart;

    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        List<Cart> cartItemList = cartService.findByShoppingCart(shoppingCart);

        for (Cart cartItem: cartItemList) {
            cartService.deleteCart(cartItem);
        }

        shoppingCart.setTotal(new BigDecimal(0));
        shoppingCartRepository.save(shoppingCart);

    }
}
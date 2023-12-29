package com.example.librarymanagementbackend.service.impl;

import com.example.librarymanagementbackend.Entity.BookToCart;
import com.example.librarymanagementbackend.Entity.Cart;
import com.example.librarymanagementbackend.Entity.Order;
import com.example.librarymanagementbackend.Entity.ShoppingCart;
import com.example.librarymanagementbackend.book.Book;
import com.example.librarymanagementbackend.repository.BookToCartRepository;
import com.example.librarymanagementbackend.repository.CartRepository;
import com.example.librarymanagementbackend.service.CartService;
import com.example.librarymanagementbackend.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;
    @Autowired
    BookToCartRepository bookToCartRepository;


    @Override
    public Cart addToCart(Book book, User user, int quantity) {
        List<Cart> cartItemList = findByShoppingCart(user.getShoppingCart());

        for (Cart cartItem: cartItemList) {
            if (book.getId() == cartItem.getBook().getId()){
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                cartItem.setSubTotal(new BigDecimal(book.getOurPrice()).multiply(new BigDecimal(quantity)));
                cartRepository.save(cartItem);
                return cartItem;
            }
        }

        Cart cartItem = new Cart();
        cartItem.setQuantity(quantity);
        cartItem.setSubTotal(new BigDecimal(book.getOurPrice()).multiply(new BigDecimal(quantity)));
        cartItem.setBook(book);
        cartItem.setShoppingCart(user.getShoppingCart());

        cartItem = cartRepository.save(cartItem);

        BookToCart bookToCartItem = new BookToCart();
        bookToCartItem.setBook(book);
        bookToCartItem.setCartItem(cartItem);
        bookToCartRepository.save(bookToCartItem);

        return cartItem;
    }

    @Override
    public List<Cart> findByShoppingCart(ShoppingCart shoppingCart) {
        return cartRepository.findByShoppingCart(shoppingCart);
    }

    @Override
    public List<Cart> findByOrder(Order order) {
        return cartRepository.findByOrder(order);
    }

    @Override
    public Cart updateCart(Cart cartItem) {
        BigDecimal bigDecimal = new BigDecimal(cartItem.getBook().getOurPrice()).multiply(new BigDecimal(cartItem.getQuantity()));
        bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        cartItem.setSubTotal(bigDecimal);
        cartRepository.save(cartItem);
        return cartItem;
    }

    @Transactional
    @Override
    public void deleteCart(Cart cartItem) {
        bookToCartRepository.deleteByCartItem(cartItem);
        cartRepository.delete(cartItem);
    }

    public Cart findById(int id) {
        return cartRepository.findById(id).get();
    }

    @Override
    public Cart save(Cart cartItem) {
        return cartRepository.save(cartItem);
    }
}

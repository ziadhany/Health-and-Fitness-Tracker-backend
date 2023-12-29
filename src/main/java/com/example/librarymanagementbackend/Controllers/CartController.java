package com.example.librarymanagementbackend.Controllers;

import com.example.librarymanagementbackend.Entity.Cart;
import com.example.librarymanagementbackend.Entity.ShoppingCart;
import com.example.librarymanagementbackend.book.Book;
import com.example.librarymanagementbackend.book.BookService;
import com.example.librarymanagementbackend.service.CartService;
import com.example.librarymanagementbackend.service.ShoppingCartService;
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
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private CartService cartService;
    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity addToCart(@RequestBody HashMap<String, String> mapper, Principal principal) {
        String bookId = mapper.get("id");
        String quantity = mapper.get("quantity");
        User user = userService.findByUsername(principal.getName());
        Book book = bookService.findBookById(Integer.parseInt(bookId));

        if (Integer.parseInt(quantity) > book.getInStockNumber()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        cartService.addToCart(book, user, Integer.parseInt(quantity));
        return new ResponseEntity( HttpStatus.OK);
    }

    @RequestMapping("/show")
    public List<Cart> getCart(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        ShoppingCart shoppingCart = user.getShoppingCart();
        List<Cart> cartItemList = cartService.findByShoppingCart(shoppingCart);
        shoppingCartService.update(shoppingCart);
        return cartItemList;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public ResponseEntity deleteCart(@RequestBody String id) {
        Cart cartItem = cartService.findById(Integer.parseInt(id));
        cartService.deleteCart(cartItem);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/updateCartItem", method = RequestMethod.POST)
    public ResponseEntity updateCart(@RequestBody HashMap<String, String> mapper) {
        String cartItemId = mapper.get("id");
        String quantity = mapper.get("quantity");
        Cart cartItem = cartService.findById(Integer.parseInt(cartItemId));
        cartItem.setQuantity(Integer.parseInt(quantity));
        cartService.updateCart(cartItem);
        return new ResponseEntity(HttpStatus.OK);
    }
}

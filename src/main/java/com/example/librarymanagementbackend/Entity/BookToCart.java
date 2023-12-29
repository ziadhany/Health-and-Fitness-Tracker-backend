package com.example.librarymanagementbackend.Entity;

import com.example.librarymanagementbackend.book.Book;
import jakarta.persistence.*;

@Entity
public class BookToCart {
    private static final long serialVersionUID = 222668L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "cart_item_id")
    private Cart cartItem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Cart getCartItem() {
        return cartItem;
    }

    public void setCartItem(Cart cartItem) {
        this.cartItem = cartItem;
    }
}

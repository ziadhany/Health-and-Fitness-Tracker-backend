package com.example.librarymanagementbackend.wishlist;

import com.example.librarymanagementbackend.book.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @ManyToMany
    @JoinTable(
            name = "wishList_book",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "bookid"))
    private List<Book> books;


}

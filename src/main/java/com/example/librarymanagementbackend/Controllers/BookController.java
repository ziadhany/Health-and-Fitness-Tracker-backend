package com.example.librarymanagementbackend.Controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.librarymanagementbackend.book.Book;
import com.example.librarymanagementbackend.book.BookRequest;
import com.example.librarymanagementbackend.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @GetMapping("/")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findBookById(id));
    }

    @PostMapping("/")
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return ResponseEntity.ok(service.saveOrUpdate(book));
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity<Book> updateBook(@PathVariable Integer id, @RequestBody Book book) {
        book.setId(id);
        return ResponseEntity.ok(service.saveOrUpdate(book));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity<Boolean> deleteBook(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.ok(true);
    }
}

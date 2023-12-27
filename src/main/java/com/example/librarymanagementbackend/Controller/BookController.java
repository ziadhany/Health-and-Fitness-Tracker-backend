package com.example.librarymanagementbackend.Controller;

import com.example.librarymanagementbackend.Entity.Book;
import com.example.librarymanagementbackend.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookService booksService;
    @GetMapping("/books/")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(booksService.getAllBooks());
    }
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getTask(@PathVariable Long id) {
        return ResponseEntity.ok(booksService.findBookById(id));
    }

    @PostMapping("/books/")
    public ResponseEntity<Book> createTask(@RequestBody Book book) {
        return ResponseEntity.ok(booksService.saveOrUpdate(book));
    }
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateTask(@PathVariable Long id, @RequestBody Book book) {
        book.setBookid(id);
        return ResponseEntity.ok(booksService.saveOrUpdate(book));
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Boolean> getAllTasks(@PathVariable Long id) {
        booksService.deleteById(id);
        return ResponseEntity.ok(true);
    }
}

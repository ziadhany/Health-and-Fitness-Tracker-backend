package com.example.librarymanagementbackend.Controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.librarymanagementbackend.book.Book;
import com.example.librarymanagementbackend.book.BookService;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    public final BookService service;
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
    @GetMapping
    @PreAuthorize("hasAuthority('admin:read')")
    public String get() {
        return "GET:: admin controller";
    }

}

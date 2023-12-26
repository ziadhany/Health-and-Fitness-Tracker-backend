//package com.example.librarymanagementbackend.services;
//import com.example.librarymanagementbackend.models.Book;
//import com.example.librarymanagementbackend.repositories.BookRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class BookService {
//    @Autowired
//    private BookRepository bookRepository;
//
//    public Book createNewBook(Book task) {
//        return bookRepository.save(task);
//    }
//
//    public List<Book> getAllBook() {
//        return bookRepository.findAll();
//    }
//
//    public Book findBookById(Long id) {
//        return bookRepository.getById(id);
//    }
//
//    public Book updateBook(Book book) {
//        return bookRepository.save(book);
//    }
//
//    public void deleteBook(long task_id) {
//        Book deleted_task = bookRepository.getById(task_id);
//        bookRepository.delete(deleted_task);
//    }
//}
//

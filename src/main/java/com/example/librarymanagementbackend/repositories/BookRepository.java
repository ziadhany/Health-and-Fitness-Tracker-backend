//package com.example.librarymanagementbackend.repositories;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//import com.example.librarymanagementbackend.models.Book;
//import java.util.List;
//
//@Repository
//public interface BookRepository extends JpaRepository<Book, Long> {
//    public Book findByTask(String task);
//    public List<Book> findByCompletedTrue();
//    public List<Book> findByCompletedFalse();
//    public List<Book> findAll();
//    public Book getById(Long id);
//
//}
package com.example.librarymanagementbackend.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    public Book findByTitle(String title);
    public List<Book> findAll();
    public Book getById(Integer id);

}

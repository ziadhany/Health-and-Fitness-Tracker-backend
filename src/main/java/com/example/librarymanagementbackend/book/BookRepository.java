package com.example.librarymanagementbackend.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    public Book findByTitle(String title);
    public List<Book> findAll();
    public Book getById(Integer id);

}

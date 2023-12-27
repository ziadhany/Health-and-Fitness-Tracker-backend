package com.example.librarymanagementbackend.Repository;
import com.example.librarymanagementbackend.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    public Book findByTitle(String title);
    public List<Book> findAll();
//    public Book getById(Long id);
}

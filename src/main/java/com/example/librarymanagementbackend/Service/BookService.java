package com.example.librarymanagementbackend.Service;

import com.example.librarymanagementbackend.Entity.Book;
import com.example.librarymanagementbackend.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository booksRepository;
    public List<Book> getAllBooks()
    {
       return booksRepository.findAll();
    }

    public Book findBookById(Long id)
    {
        return booksRepository.findById(id).get();
    }

    public Book saveOrUpdate(Book book)
    {
        return  booksRepository.save(book);
    }

    public void deleteById(Long id)
    {
        booksRepository.deleteById(id);
    }
    public void delete(Book book)
    {
        booksRepository.delete(book);
    }

}

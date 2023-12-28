package com.example.librarymanagementbackend.book;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    @Autowired
    private final BookRepository repository;

    public void save(BookRequest request) {
        var book = Book.builder()
                .id(request.getId())
                .author(request.getAuthor())
                .isbn(request.getIsbn())
                .build();
        repository.save(book);
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Book findBookById(Integer id)
    {
        return repository.findById(id).get();
    }

    public Book saveOrUpdate(Book book)
    {
        return  repository.save(book);
    }

    public void deleteById(Integer id)
    {
        repository.deleteById(id);
    }
    public void delete(Book book)
    {
        repository.delete(book);
    }
}

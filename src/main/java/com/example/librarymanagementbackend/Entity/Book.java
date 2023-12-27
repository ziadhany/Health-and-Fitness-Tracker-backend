package com.example.librarymanagementbackend.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookid;
    private String title;
    private String author;

    private String image;

    private int numOfPages;


    private String category;

    private double price;

    public Book() {
    }

    public Long getBookid()
    {
        return bookid;
    }
    public void setBookid(Long bookid)
    {
        this.bookid = bookid;
    }
    public String getTitle() {
        return title;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public void set(String title)
    {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice()
    {
        return price;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }
}

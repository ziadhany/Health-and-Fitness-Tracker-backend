//package com.example.librarymanagementbackend.models;
//import jakarta.persistence.*;
//
//import java.util.Date;
//
//@Entity
//public class Book {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    // this is the primary key which will be auto generated
//    private Long id;
//    private String author;
//    private String name;
//
//    private int rating;
//
//    @Temporal(TemporalType.DATE)
//    private Date publicationDate;
//
//    private String genre;
//
//    private String language; // TODO
//
//    private String status; // TODO
//
//
//    // private Long user_count;
//
//    public Book(long id , String name , String author) {
//        this.id = id;
//        this.name = name;
//        this.author = author;
//    }
//
//    public Book() {
//
//    }
//
//    public Long getId() {
//        return id;
//    }
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setBook(String name) {
//        this.name = name;
//    }
//}
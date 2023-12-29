package com.example.librarymanagementbackend.book;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookRequest {

    private Long id;
    private String author;
    private String isbn;
}

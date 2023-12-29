package com.example.librarymanagementbackend.user;

import java.util.List;
import java.util.Optional;

import com.example.librarymanagementbackend.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);
  User findByUsername(String username);

  public List<User> findAll();
}

package com.example.librarymanagementbackend.repository;

import com.example.librarymanagementbackend.Entity.Order;
import com.example.librarymanagementbackend.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByUser(User user);
}

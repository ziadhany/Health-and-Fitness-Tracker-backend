package com.example.librarymanagementbackend.Entity;

import com.example.librarymanagementbackend.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Data
@Getter
@Setter
@Entity
@Table(name = "user_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String orderDate;
    private String orderStatus;
    private int orderTotal;

    @Getter
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<Cart> cartItemList;

    @Getter
    @ManyToOne
    @JsonIgnore
    private User user;

}

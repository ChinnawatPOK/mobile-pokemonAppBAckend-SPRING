package com.example.pokemon.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="user_id")
    private Integer userId;

    @Column(name ="username")
    private String username;

    @Column(name = "password")
    private String password;

}

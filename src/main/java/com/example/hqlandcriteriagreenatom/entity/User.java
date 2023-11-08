package com.example.hqlandcriteriagreenatom.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "User")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "creationDate")
    private Date creationDate;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

}
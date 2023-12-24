package com.example.example3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "db_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column
    private String address;

    @Column
    private String image;

    @Column
    private String roles;

    @Column(name = "created_at", nullable = false)
    private Date created_at;

    @Column(name = "updated_at", nullable = false)
    private Date updated_at;

    @Column(name = "created_by", nullable = false)
    private int created_by;

    @Column(name = "updated_by", nullable = false)
    private int updated_by;

    @Column(nullable = false)
    private int status;

   

    // Add any other fields or relationships as needed
}

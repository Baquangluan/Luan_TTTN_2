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
@Table(name = "db_post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String topic_id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column
    private String slug;

    @Column
    private String detail;

    @Column
    private String image;

    @Column
    private String type;

    @Column
    private String metakey;

    @Column
    private String metadesc;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    @Column(nullable = false)
    private String created_by;

    @Column(nullable = false)
    private String updated_by;

    @Column(nullable = false)
    private String status;

    @Column
    private String description;

    @Column
    private String email;

    @Column
    private String fullname;



    // Add any other fields or relationships as needed
}

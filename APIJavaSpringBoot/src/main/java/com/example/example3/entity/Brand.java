package com.example.example3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "db_brand")  // Corrected the table name to "Brands"
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String slug;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String sort_order;

    @Column(nullable = false)
    private String metakey;

    @Column(nullable = false)
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

    @JsonIgnore
    @OneToMany(mappedBy = "brand")
    private List<Product> products;
}

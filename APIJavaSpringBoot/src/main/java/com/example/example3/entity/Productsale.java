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
@Table(name = "db_productsale")
public class Productsale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "sale_price", nullable = false)
    private double salePrice;

    @Column(name = "quantity_sold", nullable = false)
    private int quantitySold;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_start", nullable = false)
    private Date dateStart;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_end", nullable = false)
    private Date dateEnd;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    private Date updated_at;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "updated_by", nullable = false)
    private String updatedBy;

    @Column(name = "status", nullable = false)
    private String status;
}

package com.example.example3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.example3.entity.Productsale;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductsaleRepository extends JpaRepository<Productsale, Long> {
    Page<Productsale> findAll(Pageable pageable);
}

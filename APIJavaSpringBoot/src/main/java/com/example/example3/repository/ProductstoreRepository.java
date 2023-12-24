package com.example.example3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.example3.entity.Productstore;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductstoreRepository extends JpaRepository<Productstore, Long> {
    Page<Productstore> findAll(Pageable pageable);
}

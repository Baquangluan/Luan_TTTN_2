package com.example.example3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.example3.entity.Productoptionvalue;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductoptionvalueRepository extends JpaRepository<Productoptionvalue, Long> {
    Page<Productoptionvalue> findAll(Pageable pageable);
}

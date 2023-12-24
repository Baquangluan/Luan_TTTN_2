package com.example.example3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.example3.entity.Productimage;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductimageRepository extends JpaRepository<Productimage, Long> {
    Page<Productimage> findAll(Pageable pageable);
}

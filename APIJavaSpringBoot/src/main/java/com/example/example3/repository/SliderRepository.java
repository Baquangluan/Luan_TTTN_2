package com.example.example3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.example3.entity.Slider;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SliderRepository extends JpaRepository<Slider, Long> {
    Page<Slider> findAll(Pageable pageable);
}

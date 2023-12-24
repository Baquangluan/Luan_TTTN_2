package com.example.example3.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.example3.entity.Orderdetail;

public interface OrderdetailRepository extends JpaRepository<Orderdetail, Long> {
    Page<Orderdetail> findAll(Pageable pageable);
}

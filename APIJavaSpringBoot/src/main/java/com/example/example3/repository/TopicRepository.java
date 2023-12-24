package com.example.example3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example3.entity.Topic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    Page<Topic> findAll(Pageable pageable);
}

package com.example.example3.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.example3.entity.Topic;

public interface TopicService { // Rename the interface

    public Topic createTopic(Topic topic); // Rename the methods
    public Topic getTopicById(Long topId);
    public Page<Topic> getAllTopic(Pageable pageable);
    public Topic updateTopic(Topic topic);
    public void deleteTopic(Long topicId);
}

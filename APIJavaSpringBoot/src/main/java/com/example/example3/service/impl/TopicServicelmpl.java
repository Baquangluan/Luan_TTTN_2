package com.example.example3.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.example3.entity.Topic;
import com.example.example3.service.TopicService;
import com.example.example3.repository.TopicRepository;

import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TopicServicelmpl implements TopicService {

    private TopicRepository topicRepository;

    @Override
    public Topic createTopic(Topic topic) {
        // Set default values for the new fields
        topic.setSlug("Default Slug");
        topic.setParent_id(0L);
        topic.setMetakey("Default Metakey");
        topic.setMetadesc("Default Metadesc");
        topic.setCreated_at(new Date());
        topic.setUpdated_at(new Date());
        topic.setCreated_by("Default Creator");
        topic.setUpdated_by("Default Updater");
        topic.setStatus("Active");

        // Set the topic_date field
        // You can replace this with the actual topic date

        return topicRepository.save(topic);
    }

    @Override
    public Topic getTopicById(Long topicId) {
        Optional<Topic> optionalTopic = topicRepository.findById(topicId);
        return optionalTopic.orElse(null);
    }

    @Override
    public Page<Topic> getAllTopic(Pageable pageable) {
        return topicRepository.findAll(pageable);
    }

    @Override
    public Topic updateTopic(Topic topic) {
        Optional<Topic> optionalTopic = topicRepository.findById(topic.getId());
        if (optionalTopic.isPresent()) {
            Topic existingTopic = optionalTopic.get();
            existingTopic.setName(topic.getName());
            existingTopic.setSlug(topic.getSlug());
            existingTopic.setParent_id(topic.getParent_id());
            existingTopic.setMetakey(topic.getMetakey());
            existingTopic.setMetadesc(topic.getMetadesc());
            existingTopic.setCreated_at(new Date());
            existingTopic.setUpdated_at(new Date());

            existingTopic.setCreated_by(topic.getCreated_by());
            existingTopic.setUpdated_by(topic.getUpdated_by());
            existingTopic.setStatus(topic.getStatus());

            // Add any other fields you want to update

            return topicRepository.save(existingTopic);
        } else {
            return null;
        }
    }

    @Override
    public void deleteTopic(Long topicId) {
        topicRepository.deleteById(topicId);
    }
}

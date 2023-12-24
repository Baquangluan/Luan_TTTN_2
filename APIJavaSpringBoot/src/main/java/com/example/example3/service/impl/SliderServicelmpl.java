package com.example.example3.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.example3.entity.Slider; // Import the Slider entity
import com.example.example3.service.SliderService; // Import the SliderService
import com.example.example3.repository.SliderRepository; // Import the SliderRepository
import java.util.Optional;

@Service
@AllArgsConstructor
public class SliderServicelmpl implements SliderService { // Rename the class

    private SliderRepository sliderRepository; // Rename the repository

    @Override
    public Slider createSlider(Slider slider) {
        return sliderRepository.save(slider);
    }

    @Override
    public Slider getSliderById(Long sliderId) {
        Optional<Slider> optionalSlider = sliderRepository.findById(sliderId);
        return optionalSlider.orElse(null);
    }

    @Override
    public Page<Slider> getAllSlider(Pageable pageable) {
        return sliderRepository.findAll(pageable);
    }

    @Override
    public Slider updateSlider(Slider slider) {
        Slider existingSlider = sliderRepository.findById(slider.getId()).orElse(null);
        if (existingSlider != null) {
            existingSlider.setTitle(slider.getTitle());
            existingSlider.setLink(slider.getLink());
            existingSlider.setSortOrder(slider.getSortOrder());
            existingSlider.setPosition(slider.getPosition());
            existingSlider.setCreatedAt(slider.getCreatedAt());
            existingSlider.setUpdatedAt(slider.getUpdatedAt());
            existingSlider.setCreatedBy(slider.getCreatedBy());
            existingSlider.setUpdatedBy(slider.getUpdatedBy());
            existingSlider.setStatus(slider.getStatus());
            existingSlider.setImage(slider.getImage());
            Slider updatedSlider = sliderRepository.save(existingSlider);
            return updatedSlider;
        }
        return null;
    }

    @Override
    public void deleteSlider(Long sliderId) {
        sliderRepository.deleteById(sliderId);
    }
}
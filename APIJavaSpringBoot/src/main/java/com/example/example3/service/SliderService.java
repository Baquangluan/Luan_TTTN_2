package com.example.example3.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.example3.entity.Slider;

public interface SliderService { // Rename the interface

    public Slider createSlider(Slider slider); // Rename the methods
    public Slider getSliderById(Long sliderId);
    public Page<Slider> getAllSlider(Pageable pageable);
    public Slider updateSlider(Slider topic);
    public void deleteSlider(Long sliderId);
}

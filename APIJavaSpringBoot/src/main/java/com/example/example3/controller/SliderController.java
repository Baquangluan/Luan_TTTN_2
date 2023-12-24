package com.example.example3.controller;

import lombok.AllArgsConstructor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.example3.entity.Slider; // Import the Slider entity
import com.example.example3.service.SliderService; // Import the SliderService

@RestController
@AllArgsConstructor
@RequestMapping("api/sliders") // Change the mapping
@CrossOrigin(origins = "*", exposedHeaders = "Content-Range")
public class SliderController { // Rename the class

    private SliderService sliderService; // Rename the service

    // Create Slider REST API
    @PostMapping
    public ResponseEntity<Slider> createSlider(@RequestBody Slider slider) { // Rename the method
        slider.setImage(slider.getImage() + ".png");
        Slider savedSlider = sliderService.createSlider(slider); // Rename the service method
        return new ResponseEntity<>(savedSlider, HttpStatus.CREATED);
    }

    @PostMapping("/image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file,
            @RequestParam("customName") String customName) {
        try {
            String uploadDir = "src/main/resources/static/dataImage"; // Set your desired directory path

            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String filePath = uploadDir + File.separator + customName + ".png";

            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                fos.write(file.getBytes());
            }
            return ResponseEntity.ok("Image uploaded successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image");
        }
    }

    @GetMapping("/image/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) throws IOException {

        Resource resource = new ClassPathResource("static/dataImage/" + imageName);
        byte[] imageBytes = Files.readAllBytes(resource.getFile().toPath());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG); // Set the appropriate image media type

        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }

    // Get Slider by id REST API
    @GetMapping("{id}")public ResponseEntity<Slider> getSliderById(@PathVariable("id") Long sliderId) { // Rename the method and parameter
        Slider slider = sliderService.getSliderById(sliderId); // Rename the service method
        if (slider != null) {
            return new ResponseEntity<>(slider, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get All Sliders REST API
    @GetMapping
    public ResponseEntity<Page<Slider>> getAllSliders(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Slider> sliders = sliderService.getAllSlider(pageable); // Rename the service method
        return new ResponseEntity<>(sliders, HttpStatus.OK);
    }

    // Update Slider REST API
    @PutMapping("{id}")
    public ResponseEntity<Slider> updateSlider(@PathVariable("id") Long sliderId,
            @RequestBody Slider slider) { // Rename the method and parameter
        slider.setId(sliderId);
        Slider updatedSlider = sliderService.updateSlider(slider); // Rename the service method
        return new ResponseEntity<>(updatedSlider, HttpStatus.OK);
    }

    // Delete Slider REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSlider(@PathVariable("id") Long sliderId) { // Rename the parameter
        sliderService.deleteSlider(sliderId); // Rename the service method
        return new ResponseEntity<>("Slider successfully deleted!", HttpStatus.OK);
    }
}
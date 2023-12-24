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

import com.example.example3.entity.User; // Import the User entity
import com.example.example3.service.UserService; // Import the UserService

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
@CrossOrigin(origins = "*", exposedHeaders = "Content-Range")
public class UserController { 

    private UserService userService; // Rename the service

    // Create User REST API
    @PostMapping
    public ResponseEntity<User> CreateUser(@RequestBody User user) { // Rename the method
        user.setImage(user.getImage() + ".png");
        User savedUser = userService.CreateUser(user); // Rename the service method
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
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


    // Get User by id REST API
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) { // Rename the method and parameter
        User user = userService.getUserById(userId); // Rename the service method
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get All Users REST API
    @GetMapping
    public ResponseEntity<Page<User>> getAllUsers(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<User> users = userService.getAllUsers(pageable); // Rename the service method
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Update User REST API
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId,
            @RequestBody User user) { // Rename the method and parameter
        user.setId(userId);
        User updatedUser = userService.updateUser(user); // Rename the service method
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) { // Rename the parameter
        userService.deleteUser(userId); // Rename the service method
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}

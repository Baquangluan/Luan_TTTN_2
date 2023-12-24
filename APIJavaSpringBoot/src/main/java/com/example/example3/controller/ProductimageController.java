package com.example.example3.controller;

import lombok.AllArgsConstructor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.example3.entity.Productimage;
import com.example.example3.service.ProductimageService;

@RestController
@AllArgsConstructor
@RequestMapping("api/productimage")
@CrossOrigin(origins = "*", exposedHeaders = "Content-Range")
public class ProductimageController {

    private ProductimageService productimageService;

    @PostMapping("/image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file,
            @RequestParam("customName") String customName) {
        try {
            String uploadDir = "src/main/resources/static/dataImage";

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
        headers.setContentType(MediaType.IMAGE_JPEG);

        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Productimage> getProductimageById(@PathVariable("id") Long productimageId) {
        Productimage productimage = productimageService.getProductimageById(productimageId);
        return new ResponseEntity<>(productimage, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Productimage>> getAllProductimages(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Productimage> productimagePage = productimageService.getAllProductimage(pageable);

        return new ResponseEntity<>(productimagePage, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Productimage> updateProductimage(@PathVariable("id") Long productimageId,
            @RequestBody Productimage productimage) {
        productimage.setId(productimageId);
        Productimage updatedProductimage = productimageService.updateProductimage(productimage);
        return new ResponseEntity<>(updatedProductimage, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProductimage(@PathVariable("id") Long productimageId) {
        productimageService.deleteProductimage(productimageId);
        return new ResponseEntity<>("Productimage successfully deleted!", HttpStatus.OK);
    }
}

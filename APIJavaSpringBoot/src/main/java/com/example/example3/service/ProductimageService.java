package com.example.example3.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.example3.entity.Productimage;

public interface ProductimageService {
    Productimage createProductimage(Productimage productimage);

    Productimage getProductimageById(Long productimagetId);

    Page<Productimage> getAllProductimage(Pageable pageable);

    Productimage updateProductimage(Productimage productimage);

    void deleteProductimage(Long productimageId);
    // public void saveImage(MultipartFile file) throws IOException;
}

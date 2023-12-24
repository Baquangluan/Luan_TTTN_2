package com.example.example3.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.example3.entity.Productoption;

public interface ProductoptionService {
    Productoption createProductoption(Productoption productoption);

    Productoption getProductoptionById(Long productoptionId);

    Page<Productoption> getAllProductoption(Pageable pageable);

    Productoption updateProductoption(Productoption productoption);

    void deleteProductoption(Long productoptionId);
    // public void saveImage(MultipartFile file) throws IOException;
}

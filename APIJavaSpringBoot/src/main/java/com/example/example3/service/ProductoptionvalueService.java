package com.example.example3.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.example3.entity.Productoptionvalue;

public interface ProductoptionvalueService {
    Productoptionvalue createProductoptionvalue(Productoptionvalue productoptionvalue);

    Productoptionvalue getProductoptionvalueById(Long productoptionvalueId);

    Page<Productoptionvalue> getAllProductoptionvalue(Pageable pageable);

    Productoptionvalue updateProductoptionvalue(Productoptionvalue productoptionvalue);

    void deleteProductoptionvalue(Long productoptionvalueId);
    // public void saveImage(MultipartFile file) throws IOException;
}

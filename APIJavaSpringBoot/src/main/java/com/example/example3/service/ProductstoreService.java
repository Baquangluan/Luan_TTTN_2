package com.example.example3.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.example3.entity.Productstore;

public interface ProductstoreService {
    Productstore createProductstore(Productstore productstore);

    Productstore getProductstoreById(Long productstoreId);

    Page<Productstore> getAllProductstore(Pageable pageable);

    Productstore updateProductstore(Productstore productstore);

    void deleteProductstore(Long productstoreId);
    // public void saveImage(MultipartFile file) throws IOException;
}

package com.example.example3.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.example3.entity.Productsale;

public interface ProductsaleService {
    Productsale createProductsale(Productsale productsale);

    Productsale getProductsaleById(Long productsaleId);

    Page<Productsale> getAllProductsale(Pageable pageable);

    Productsale updateProductsale(Productsale productsale);

    void deleteProductsale(Long productsaleId);
    // public void saveImage(MultipartFile file) throws IOException;
}

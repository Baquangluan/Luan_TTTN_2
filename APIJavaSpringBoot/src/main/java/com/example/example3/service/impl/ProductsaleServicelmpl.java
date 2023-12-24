package com.example.example3.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.example3.entity.Productsale;  // Change import statement
import com.example.example3.service.ProductsaleService;  // Change service interface
import com.example.example3.repository.ProductsaleRepository;  // Add import statement for ProductsaleRepository

import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductsaleServicelmpl implements ProductsaleService {

    private ProductsaleRepository productsaleRepository;  // Add repository for Productsale

    @Override
    public Productsale createProductsale(Productsale productsale) {
    // Set default values for the new fields
    productsale.setCreated_at(new Date());
    productsale.setUpdated_at(new Date());

    // Set the default value for any other new fields
    // For example, assuming you have a default value for createdBy and updatedBy
    productsale.setCreatedBy("defaultCreatedBy");
    productsale.setUpdatedBy("defaultUpdatedBy");

    // You can set default values for other fields as needed

    return productsaleRepository.save(productsale);
}


    @Override
    public Productsale getProductsaleById(Long productsaleId) {
        Optional<Productsale> optionalProductsale = productsaleRepository.findById(productsaleId);
        return optionalProductsale.orElse(null);
    }

    @Override
    public Page<Productsale> getAllProductsale(Pageable pageable) {
        return productsaleRepository.findAll(pageable);
    }

    @Override
    public Productsale updateProductsale(Productsale productsale) {
        Productsale existingProductsale = productsaleRepository.findById(productsale.getId()).orElse(null);
        if (existingProductsale != null) {
            existingProductsale.setProduct(productsale.getProduct());
            existingProductsale.setSalePrice(productsale.getSalePrice());
            existingProductsale.setQuantitySold(productsale.getQuantitySold());
            existingProductsale.setDateStart(productsale.getDateStart());
            existingProductsale.setDateEnd(productsale.getDateEnd());
            existingProductsale.setCreated_at(new Date());
            existingProductsale.setUpdated_at(new Date());
            existingProductsale.setCreatedBy(productsale.getCreatedBy());
            existingProductsale.setUpdatedBy(productsale.getUpdatedBy());
            existingProductsale.setStatus(productsale.getStatus());

            Productsale updatedProductsale = productsaleRepository.save(existingProductsale);
            return updatedProductsale;
        }
        return null; // Handle error or throw an exception as needed
    }

    @Override
    public void deleteProductsale(Long productsaleId) {
        productsaleRepository.deleteById(productsaleId);
    }
}

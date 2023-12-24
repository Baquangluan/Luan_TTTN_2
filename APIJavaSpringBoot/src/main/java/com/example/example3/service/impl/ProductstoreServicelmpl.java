package com.example.example3.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.example3.entity.Productstore;  // Change import statement
import com.example.example3.service.ProductstoreService;  // Change service interface
import com.example.example3.repository.ProductstoreRepository;  // Add import statement for ProductstoreRepository

import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductstoreServicelmpl implements ProductstoreService {

    private ProductstoreRepository productstoreRepository;  // Add repository for Productstore

    @Override
    public Productstore createProductstore(Productstore productstore) {
        // Set default values for the new fields
        productstore.setCreated_at(new Date());
        productstore.setUpdated_at(new Date());
        productstore.setCreatedBy("defaultCreatedBy");
        productstore.setUpdatedBy("defaultUpdatedBy");

        // Set the values for the additional fields
        productstore.setQuantityAdded(productstore.getQuantityAdded());
        productstore.setEntryDate(productstore.getEntryDate());
        productstore.setStatus(productstore.getStatus());

        // You can set default values for other fields as needed

        return productstoreRepository.save(productstore);
    }

    @Override
    public Productstore getProductstoreById(Long productstoreId) {
        Optional<Productstore> optionalProductstore = productstoreRepository.findById(productstoreId);
        return optionalProductstore.orElse(null);
    }

    @Override
    public Page<Productstore> getAllProductstore(Pageable pageable) {
        return productstoreRepository.findAll(pageable);
    }

    @Override
    public Productstore updateProductstore(Productstore productstore) {
        Productstore existingProductstore = productstoreRepository.findById(productstore.getId()).orElse(null);
        if (existingProductstore != null) {
            existingProductstore.setProduct(productstore.getProduct());
            existingProductstore.setQuantityAdded(productstore.getQuantityAdded());
            existingProductstore.setEntryDate(productstore.getEntryDate());
            existingProductstore.setCreated_at(new Date());
            existingProductstore.setUpdated_at(new Date());
            existingProductstore.setCreatedBy(productstore.getCreatedBy());
            existingProductstore.setUpdatedBy(productstore.getUpdatedBy());
            existingProductstore.setStatus(productstore.getStatus());

            Productstore updatedProductstore = productstoreRepository.save(existingProductstore);
            return updatedProductstore;
        }
        return null; // Handle error or throw an exception as needed
    }

    @Override
    public void deleteProductstore(Long productstoreId) {
        productstoreRepository.deleteById(productstoreId);
    }
}

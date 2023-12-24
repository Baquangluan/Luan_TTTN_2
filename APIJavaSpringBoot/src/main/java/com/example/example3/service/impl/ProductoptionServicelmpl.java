package com.example.example3.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.example3.entity.Productoption;
import com.example.example3.service.ProductoptionService;
import com.example.example3.repository.ProductoptionRepository;

import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoptionServicelmpl implements ProductoptionService {

    private ProductoptionRepository productoptionRepository;

    @Override
    public Productoption createProductoption(Productoption productoption) {
        // Set default values for the new fields
      
        productoption.setCreated_at(new Date());
        productoption.setUpdated_at(new Date());

        return productoptionRepository.save(productoption);
    }

    @Override
    public Productoption getProductoptionById(Long productoptionId) {
        Optional<Productoption> optionalProductoption = productoptionRepository.findById(productoptionId);
        return optionalProductoption.orElse(null);
    }

    @Override
    public Page<Productoption> getAllProductoption(Pageable pageable) {
        return productoptionRepository.findAll(pageable);
    }

    @Override
    public Productoption updateProductoption(Productoption productoption) {
        Productoption existingProductoption = productoptionRepository.findById(productoption.getId()).orElse(null);
        if (existingProductoption != null) {
            existingProductoption.setName(productoption.getName());
            existingProductoption.setProduct(productoption.getProduct());
            existingProductoption.setCreated_at(new Date());
            existingProductoption.setUpdated_at(new Date());
            Productoption updatedProductoption = productoptionRepository.save(existingProductoption);
            return updatedProductoption;
        }
        return null; // Handle error or throw an exception as needed
    }

    @Override
    public void deleteProductoption(Long productoptionId) {
        productoptionRepository.deleteById(productoptionId);
    }
}

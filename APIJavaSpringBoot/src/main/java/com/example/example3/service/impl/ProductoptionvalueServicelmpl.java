package com.example.example3.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.example3.entity.Productoptionvalue;  // Change import statement
import com.example.example3.service.ProductoptionvalueService;
import com.example.example3.repository.ProductoptionvalueRepository;  // Add import statement for ProductoptionvalueRepository

import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoptionvalueServicelmpl implements ProductoptionvalueService {


    private ProductoptionvalueRepository productoptionvalueRepository;  // Add repository for Productoptionvalue

    @Override
    public Productoptionvalue createProductoptionvalue(Productoptionvalue productoptionvalue) {
        // Set default values for the new fields
        productoptionvalue.setCreated_at(new Date());
        productoptionvalue.setUpdated_at(new Date());

        return productoptionvalueRepository.save(productoptionvalue);
    }

    @Override
    public Productoptionvalue getProductoptionvalueById(Long productoptionvalueId) {
        Optional<Productoptionvalue> optionalProductoptionvalue = productoptionvalueRepository.findById(productoptionvalueId);
        return optionalProductoptionvalue.orElse(null);
    }

    @Override
    public Page<Productoptionvalue> getAllProductoptionvalue(Pageable pageable) {
        return productoptionvalueRepository.findAll(pageable);
    }

    @Override
    public Productoptionvalue updateProductoptionvalue (Productoptionvalue productoptionvalue) {
        Productoptionvalue existingProductoptionvalue = productoptionvalueRepository.findById(productoptionvalue.getId()).orElse(null);
        if (existingProductoptionvalue != null) {
            existingProductoptionvalue.setName(productoptionvalue.getName());
            existingProductoptionvalue.setProduct(productoptionvalue.getProduct());
            existingProductoptionvalue.setCreated_at(new Date());
            existingProductoptionvalue.setUpdated_at(new Date());
            Productoptionvalue updatedProductoptionvalue = productoptionvalueRepository.save(existingProductoptionvalue);
            return updatedProductoptionvalue;
        }
        return null; // Handle error or throw an exception as needed
    }

    @Override
    public void deleteProductoptionvalue(Long productoptionvalueId) {
        productoptionvalueRepository.deleteById(productoptionvalueId);
    }
}

package com.example.example3.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.example3.entity.Productimage;
import com.example.example3.service.ProductimageService;
import com.example.example3.repository.ProductimageRepository;

import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductimageServicelmpl implements ProductimageService {

    private ProductimageRepository productimageRepository;

    @Override
    public Productimage createProductimage(Productimage productimage) {
        // Set default values for the new fields
        productimage.setImage("Default Image");
        
        productimage.setCreated_at(new Date());
        productimage.setUpdated_at(new Date());

        return productimageRepository.save(productimage);
    }

    @Override
    public Productimage getProductimageById(Long productimageId) {
        Optional<Productimage> optionalProductimage = productimageRepository.findById(productimageId);
        return optionalProductimage.orElse(null);
    }

    @Override
    public Page<Productimage> getAllProductimage(Pageable pageable) {
        return productimageRepository.findAll(pageable);
    }

    @Override
    public Productimage updateProductimage(Productimage productimage) {
        Productimage existingProductimage = productimageRepository.findById(productimage.getId()).orElse(null);
        if (existingProductimage != null) {
            existingProductimage.setName(productimage.getName());
            existingProductimage.setImage(productimage.getImage());
           
            existingProductimage.setProduct(productimage.getProduct());
            existingProductimage.setCreated_at(new Date());
            existingProductimage.setUpdated_at(new Date());

            Productimage updatedProductimage = productimageRepository.save(existingProductimage);
            return updatedProductimage;
        }
        return null; // Handle error or throw an exception as needed
    }

    @Override
    public void deleteProductimage(Long productimageId) {
        productimageRepository.deleteById(productimageId);
    }
}

package com.example.example3.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.example3.entity.Brand;

import com.example.example3.service.BrandService;

import com.example.example3.repository.BrandRepository;
import java.util.Date;  // Add this import statement
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandServicelmpl implements BrandService {

    private BrandRepository brandRepository;

    @Override
    public Brand createBrand(Brand brand) {
        // Set default values for the new fields
        brand.setMetadesc("Default Metadesc");
        brand.setCreated_at(new Date());
        brand.setUpdated_at(new Date());
        brand.setCreated_by("Default Creator");
        brand.setUpdated_by("Default Updater");
        brand.setStatus("Active");

        return brandRepository.save(brand);
    }

    @Override
    public Brand getBrandById(Long brandId) {
        Optional<Brand> optionalBrand = brandRepository.findById(brandId);
        return optionalBrand.orElse(null);
    }

    @Override
    public Page<Brand> getAllBrandes(Pageable pageable) {
        return brandRepository.findAll(pageable);
    }

    @Override
    public Brand updateBrand(Brand brand) {
        Brand existingBrand = brandRepository.findById(brand.getId()).orElse(null);
        if (existingBrand != null) {
            existingBrand.setName(brand.getName());
            existingBrand.setSlug(brand.getSlug());
            existingBrand.setImage(brand.getImage());
            existingBrand.setSort_order(brand.getSort_order());
            existingBrand.setMetakey(brand.getMetakey());
            existingBrand.setMetadesc(brand.getMetadesc());  // Added this line
            existingBrand.setCreated_at(new Date());  // Updated this line
            existingBrand.setUpdated_at(new Date());  // Added this line
            existingBrand.setCreated_by(brand.getCreated_by());  // Added this line
            existingBrand.setUpdated_by(brand.getUpdated_by());  // Added this line
            existingBrand.setStatus(brand.getStatus());  // Added this line
            existingBrand.setProducts(brand.getProducts());
            return brandRepository.save(existingBrand);
        }
        return null; // Handle error or throw an exception as needed
    }

    @Override
    public void deleteBrand(Long brandId) {
        brandRepository.deleteById(brandId);
    }
}

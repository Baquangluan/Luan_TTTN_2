package com.example.example3.controller;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.example3.entity.Brand;
import com.example.example3.service.BrandService;

@RestController
@AllArgsConstructor
@RequestMapping("api/brand")
@CrossOrigin(origins = "http://localhost:3001", exposedHeaders = "Content-Range")

public class BrandController {

    private BrandService brandService;

    // Create Brand REST API
    @PostMapping
    public ResponseEntity<Brand> createBrand(@RequestBody Brand brand) {
        Brand savedBrand = brandService.createBrand(brand);
        return new ResponseEntity<>(savedBrand, HttpStatus.CREATED);
    }

    // Get Category by id REST API
    // http://localhost:8080/api/Categories/1
    @GetMapping("{id}")
    public ResponseEntity<Brand> getcreateBrandById(@PathVariable("id") Long brandId) {
        Brand brand = brandService.getBrandById(brandId);
        if (brand != null) {
            return new ResponseEntity<>(brand, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get All Categorys REST API
    // http://localhost:8080/api/Categories
    @GetMapping
    public ResponseEntity<Page<Brand>> getAllBrand(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Brand> Brandes = brandService.getAllBrandes(pageable);
        return new ResponseEntity<>(Brandes, HttpStatus.OK);
    }

    // Update Category REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/Categories/1
    public ResponseEntity<Brand> updateBrand(@PathVariable("id") Long brandId,
            @RequestBody Brand Brand) {
        Brand.setId(brandId);
        Brand updatedBrand = brandService.updateBrand(Brand);
        return new ResponseEntity<>(updatedBrand, HttpStatus.OK);
    }

    // Delete Category REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBrand(@PathVariable("id") Long brandId) {
        brandService.deleteBrand(brandId);
        return new ResponseEntity<>("Brand successfully deleted!", HttpStatus.OK);
    }
}

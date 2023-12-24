package com.example.example3.controller;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.example3.entity.Productsale;  // Change import statement
import com.example.example3.service.ProductsaleService;  // Change service interface

@RestController
@AllArgsConstructor
@RequestMapping("api/productsale")  // Change the path to "api/productsales"
@CrossOrigin(origins = "*", exposedHeaders = "Content-Range")
public class ProductsaleController {

    private ProductsaleService productsaleService;  // Change service interface

    @PostMapping
    public ResponseEntity<Productsale> createProductsale(@RequestBody Productsale productsale) {
        Productsale savedProductsale = productsaleService.createProductsale(productsale);
        return new ResponseEntity<>(savedProductsale, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Productsale> getProductsaleById(@PathVariable("id") Long productsaleId) {
        Productsale productsale = productsaleService.getProductsaleById(productsaleId);
        if (productsale != null) {
            return new ResponseEntity<>(productsale, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Page<Productsale>> getAllProductsales(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Productsale> productsales = productsaleService.getAllProductsale(pageable);
        return new ResponseEntity<>(productsales, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Productsale> updateProductsale(@PathVariable("id") Long productsaleId,
            @RequestBody Productsale productsale) {
        productsale.setId(productsaleId);
        Productsale updatedProductsale = productsaleService.updateProductsale(productsale);
        return new ResponseEntity<>(updatedProductsale, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProductsale(@PathVariable("id") Long productsaleId) {
        productsaleService.deleteProductsale(productsaleId);
        return new ResponseEntity<>("Productsale successfully deleted!", HttpStatus.OK);
    }
}

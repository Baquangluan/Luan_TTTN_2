package com.example.example3.controller;

import lombok.AllArgsConstructor;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.example3.entity.Productoption;
import com.example.example3.service.ProductoptionService;

@RestController
@AllArgsConstructor
@RequestMapping("api/productoption")  // Change the path to "api/productoptions"
@CrossOrigin(origins = "*", exposedHeaders = "Content-Range")
public class ProductoptionController {

    private ProductoptionService productoptionService;  // Change TopicService to ProductoptionService

    @PostMapping
    public ResponseEntity<Productoption> createProductoption(@RequestBody Productoption productoption) {
        Productoption savedProductoption = productoptionService.createProductoption(productoption);
        return new ResponseEntity<>(savedProductoption, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Productoption> getProductoptionById(@PathVariable("id") Long productoptionId) {
        Productoption productoption = productoptionService.getProductoptionById(productoptionId);
        if (productoption != null) {
            return new ResponseEntity<>(productoption, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Page<Productoption>> getAllProductoptions(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Productoption> productoptions = productoptionService.getAllProductoption(pageable);
        return new ResponseEntity<>(productoptions, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Productoption> updateProductoption(@PathVariable("id") Long productoptionId,
            @RequestBody Productoption productoption) {
        productoption.setId(productoptionId);
        Productoption updatedProductoption = productoptionService.updateProductoption(productoption);
        return new ResponseEntity<>(updatedProductoption, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProductoption(@PathVariable("id") Long productoptionId) {
        productoptionService.deleteProductoption(productoptionId);
        return new ResponseEntity<>("Productoption successfully deleted!", HttpStatus.OK);
    }
}


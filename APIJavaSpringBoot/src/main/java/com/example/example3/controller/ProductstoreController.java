package com.example.example3.controller;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.example3.entity.Productstore;  // Change import statement
import com.example.example3.service.ProductstoreService;  // Change service interface

@RestController
@AllArgsConstructor
@RequestMapping("api/productstore")  // Change the path to "api/productstores"
@CrossOrigin(origins = "*", exposedHeaders = "Content-Range")
public class ProductstoreController {

    private ProductstoreService productstoreService;  // Change service interface

    @PostMapping
    public ResponseEntity<Productstore> createProductstore(@RequestBody Productstore productstore) {
        Productstore savedProductstore = productstoreService.createProductstore(productstore);
        return new ResponseEntity<>(savedProductstore, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Productstore> getProductstoreById(@PathVariable("id") Long productstoreId) {
        Productstore productstore = productstoreService.getProductstoreById(productstoreId);
        if (productstore != null) {
            return new ResponseEntity<>(productstore, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Page<Productstore>> getAllProductstores(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Productstore> productstores = productstoreService.getAllProductstore(pageable);
        return new ResponseEntity<>(productstores, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Productstore> updateProductstore(@PathVariable("id") Long productstoreId,
            @RequestBody Productstore productstore) {
        productstore.setId(productstoreId);
        Productstore updatedProductstore = productstoreService.updateProductstore(productstore);
        return new ResponseEntity<>(updatedProductstore, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProductstore(@PathVariable("id") Long productstoreId) {
        productstoreService.deleteProductstore(productstoreId);
        return new ResponseEntity<>("Productstore successfully deleted!", HttpStatus.OK);
    }
}

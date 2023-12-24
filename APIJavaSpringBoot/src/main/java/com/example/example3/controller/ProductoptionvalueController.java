package com.example.example3.controller;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.example3.entity.Productoptionvalue;  // Change import statement
import com.example.example3.service.ProductoptionvalueService;  // Change service interface

@RestController
@AllArgsConstructor
@RequestMapping("api/productoptionvalue")  // Change the path to "api/productoptionvalues"
@CrossOrigin(origins = "*", exposedHeaders = "Content-Range")
public class ProductoptionvalueController {

    private ProductoptionvalueService productoptionvalueService;  // Change service interface

    @PostMapping
    public ResponseEntity<Productoptionvalue> createProductoptionvalue(@RequestBody Productoptionvalue productoptionvalue) {
        Productoptionvalue savedProductoptionvalue = productoptionvalueService.createProductoptionvalue(productoptionvalue);
        return new ResponseEntity<>(savedProductoptionvalue, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Productoptionvalue> getProductoptionvalueById(@PathVariable("id") Long productoptionvalueId) {
        Productoptionvalue productoptionvalue = productoptionvalueService.getProductoptionvalueById(productoptionvalueId);
        if (productoptionvalue != null) {
            return new ResponseEntity<>(productoptionvalue, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Page<Productoptionvalue>> getAllProductoptionvalues(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Productoptionvalue> productoptionvalues = productoptionvalueService.getAllProductoptionvalue(pageable);
        return new ResponseEntity<>(productoptionvalues, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Productoptionvalue> updateProductoptionvalue(@PathVariable("id") Long productoptionvalueId,
            @RequestBody Productoptionvalue productoptionvalue) {
        productoptionvalue.setId(productoptionvalueId);
        Productoptionvalue updatedProductoptionvalue = productoptionvalueService.updateProductoptionvalue(productoptionvalue);
        return new ResponseEntity<>(updatedProductoptionvalue, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProductoptionvalue(@PathVariable("id") Long productoptionvalueId) {
        productoptionvalueService.deleteProductoptionvalue(productoptionvalueId);
        return new ResponseEntity<>("Productoptionvalue successfully deleted!", HttpStatus.OK);
    }
}

package com.example.example3.controller;

import lombok.AllArgsConstructor;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.example3.entity.Product;
import com.example.example3.service.ProductService;

@RestController
@AllArgsConstructor
@RequestMapping("api/products")
@CrossOrigin(origins = "http://localhost:3001", exposedHeaders = "Content-Range")
public class ProductController {

    private ProductService productService;

    // Create Product REST API
    

     @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
          if (product.getCreated_at() == null) {
            product.setCreated_at(new Date());
        }

        // Kiểm tra nếu createdAt lớn hơn ngày hiện tại, đặt lại thành ngày hiện tại
        Date createdAt = product.getCreated_at();
        if (createdAt != null && createdAt.after(new Date())) {
            product.setCreated_at(new Date());
        }
        Product savedProduct= productService.createProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    // Get Product by id REST API
    // http://localhost:8080/api/Products/1
    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long ProductId) {
        Product Product = productService.getProductById(ProductId);
        return new ResponseEntity<>(Product, HttpStatus.OK);
    }

    // Get All Products REST API
    // http://localhost:8080/api/Products

    @GetMapping
    public ResponseEntity<Page<Product>> getAllProducts(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = productService.getAllProducts(pageable);

        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }

    // Update Product REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/Products/1
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long ProductId,
            @RequestBody Product Product) {
        Product.setId(ProductId);
        Product updatedProduct = productService.updateProduct(Product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    // Delete Product REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long ProductId) {
        productService.deleteProduct(ProductId);
        return new ResponseEntity<>("Product successfully deleted!", HttpStatus.OK);
    }
}

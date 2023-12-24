package com.example.example3.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.example3.entity.Product;
import com.example.example3.service.ProductService;
import com.example.example3.repository.ProductRepository;

import java.util.Date;  // Add this import statement
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        // Set default values for the new fields
        product.setTitle("Default Title");
        product.setQty(0);
        product.setDescription("Default Description");
        product.setMetakey("Default Metakey");
        product.setMetadesc("Default Metadesc");
        product.setCreated_at(new Date());
        product.setUpdated_at(new Date());
        product.setCreated_by("Default Creator");
        product.setUpdated_by("Default Updater");
        product.setStatus("Active");

        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        return optionalProduct.orElse(null);
    }

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        if (existingProduct != null) {
            existingProduct.setTitle(product.getTitle());
            existingProduct.setSlug(product.getSlug());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setQty(product.getQty());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setBrand(product.getBrand());
            existingProduct.setMetakey(product.getMetakey());
            existingProduct.setMetadesc(product.getMetadesc());
            existingProduct.setCreated_at(new Date());
            existingProduct.setUpdated_at(new Date());
            existingProduct.setCreated_by(product.getCreated_by());
            existingProduct.setUpdated_by(product.getUpdated_by());
            existingProduct.setStatus(product.getStatus());

            Product updatedProduct = productRepository.save(existingProduct);
            return updatedProduct;
        }
        return null; // Handle error or throw an exception as needed
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}

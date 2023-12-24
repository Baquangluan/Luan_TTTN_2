package com.example.example3.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.example3.entity.Category;
import com.example.example3.service.CategoryService;
import com.example.example3.repository.CategoryRepository;
import java.util.Date;  // Add this import statement
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        // Set default values for the new fields
        category.setImage("Default Image");
        category.setParent_id(0L);
        category.setSort_order("Default Sort Order");
        category.setMetakey("Default Metakey");
        category.setMetadesc("Default Metadesc");
        category.setCreated_at(new Date());
        category.setUpdated_at(new Date());
        category.setCreated_by("Default Creator");
        category.setUpdated_by("Default Updater");
        category.setStatus("Active");

        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        return optionalCategory.orElse(null);
    }

    @Override
    public Page<Category> getAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category updateCategory(Category category) {
        Category existingCategory = categoryRepository.findById(category.getId()).orElse(null);
        if (existingCategory != null) {
            existingCategory.setName(category.getName());
            existingCategory.setSlug(category.getSlug());
            existingCategory.setImage(category.getImage());
            existingCategory.setParent_id(category.getParent_id());
            existingCategory.setSort_order(category.getSort_order());
            existingCategory.setMetakey(category.getMetakey());
            existingCategory.setMetadesc(category.getMetadesc());
            existingCategory.setCreated_at(new Date());
            existingCategory.setUpdated_at(new Date());
            existingCategory.setCreated_by(category.getCreated_by());
            existingCategory.setUpdated_by(category.getUpdated_by());
            existingCategory.setStatus(category.getStatus());
            existingCategory.setProducts(category.getProducts());

            Category updatedCategory = categoryRepository.save(existingCategory);
            return updatedCategory;
        }
        return null; // Handle error or throw an exception as needed
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}

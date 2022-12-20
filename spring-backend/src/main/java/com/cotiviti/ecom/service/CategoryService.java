package com.cotiviti.ecom.service;

import com.cotiviti.ecom.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO saveCategory(CategoryDTO categoryDTO);
    List<CategoryDTO> getAllCategories();

}

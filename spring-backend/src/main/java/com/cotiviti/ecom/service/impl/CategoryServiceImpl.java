package com.cotiviti.ecom.service.impl;

import com.cotiviti.ecom.dto.CategoryDTO;
import com.cotiviti.ecom.model.Category;
import com.cotiviti.ecom.repository.CategoryRepository;
import com.cotiviti.ecom.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
        Category category = dtoToClass(categoryDTO);
        Category saved = categoryRepository.save(category);
        return classToDTO(saved);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map((cat) -> this.modelMapper.map(cat, CategoryDTO.class))
                .collect(Collectors.toList());
    }


    private Category dtoToClass(CategoryDTO dto) {
        return modelMapper.map(dto, Category.class);
    }

    private CategoryDTO classToDTO(Category user) {
        return modelMapper.map(user, CategoryDTO.class);
    }

}

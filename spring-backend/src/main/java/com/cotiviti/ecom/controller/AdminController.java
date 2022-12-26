package com.cotiviti.ecom.controller;

import com.cotiviti.ecom.dto.CategoryDTO;
import com.cotiviti.ecom.dto.ItemDTO;
import com.cotiviti.ecom.service.CategoryService;
import com.cotiviti.ecom.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    ItemService itemService;

    @Autowired
    CategoryService categoryService;

    @PostMapping(path = "/addItem/{categoryId}" , consumes = { "multipart/form-data" })
    public ResponseEntity<ItemDTO> addItem(
            @Valid @RequestBody ItemDTO itemDTO,
            @PathVariable("categoryId") Integer categoryId) {
        ItemDTO createdItemDTO = itemService.addItem(itemDTO, categoryId);
        return new ResponseEntity<>(createdItemDTO, HttpStatus.OK);
    }

    @PostMapping("/addCategory")
    public ResponseEntity<CategoryDTO> addCategory(
            @Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO createdCategoryDTO = categoryService.saveCategory(categoryDTO);
        return new ResponseEntity<>(createdCategoryDTO, HttpStatus.CREATED);

    }
}

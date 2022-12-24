package com.cotiviti.ecom.controller;

import com.cotiviti.ecom.dto.CategoryDTO;
import com.cotiviti.ecom.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")

public class CategoryController {

    @Autowired
    CategoryService categoryService;




}

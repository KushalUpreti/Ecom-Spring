package com.cotiviti.ecom.controller;

import com.cotiviti.ecom.dto.CategoryDTO;
import com.cotiviti.ecom.dto.ItemDTO;
import com.cotiviti.ecom.service.CategoryService;
import com.cotiviti.ecom.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/guest")
public class GuestController {

    @Autowired
    ItemService itemService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/item/{categoryId}")
    public ResponseEntity<List<ItemDTO>> getCategoryItems(@PathVariable("categoryId") Integer categoryId) {
        List<ItemDTO> itemDTOList = itemService.getCategoryItems(categoryId);
        return new ResponseEntity<>(itemDTOList, HttpStatus.CREATED);
    }

    @GetMapping("/item/getItem/{itemId}")
    public ResponseEntity<ItemDTO> getItem(@PathVariable("itemId") Integer itemId) {
        ItemDTO itemDTO = itemService.getItem(itemId);
        return new ResponseEntity<>(itemDTO, HttpStatus.CREATED);
    }

    @GetMapping("/category/")
    public ResponseEntity<List<CategoryDTO>> getCategories() {
        List<CategoryDTO> categoryDTOList = categoryService.getAllCategories();
        return new ResponseEntity<>(categoryDTOList, HttpStatus.OK);
    }
}

package com.cotiviti.ecom.controller;

import com.cotiviti.ecom.dto.ItemDTO;
import com.cotiviti.ecom.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/{categoryId}")
    public ResponseEntity<List<ItemDTO>> getCategoryItems(@PathVariable("categoryId") Integer categoryId) {
        List<ItemDTO> itemDTOList = itemService.getCategoryItems(categoryId);
        return new ResponseEntity<>(itemDTOList, HttpStatus.CREATED);
    }

    @PostMapping("/add/{categoryId}")
    public ResponseEntity<ItemDTO> addItem(
            @Valid @RequestBody ItemDTO itemDTO,
            @PathVariable("categoryId") Integer categoryId) {
        ItemDTO createdItemDTO = itemService.addItem(itemDTO, categoryId);
        return new ResponseEntity<>(createdItemDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{itemId}")
    public ResponseEntity<String> deleteItem(@PathVariable("itemId") Integer itemId) {
        itemService.deleteItem(itemId);
        return new ResponseEntity<>("Item deleted", HttpStatus.GONE);
    }


}

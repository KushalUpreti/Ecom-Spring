package com.cotiviti.ecom.service;

import com.cotiviti.ecom.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    ItemDTO addItem(ItemDTO itemDTO, Integer categoryId);
    void deleteItem(Integer itemId);
    List<ItemDTO> getCategoryItems(Integer categoryId);
}

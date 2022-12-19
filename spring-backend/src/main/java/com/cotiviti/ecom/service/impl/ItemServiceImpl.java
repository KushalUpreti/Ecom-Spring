package com.cotiviti.ecom.service.impl;

import com.cotiviti.ecom.dto.ItemDTO;
import com.cotiviti.ecom.exception.ResourceNotFoundException;
import com.cotiviti.ecom.model.Category;
import com.cotiviti.ecom.model.Item;
import com.cotiviti.ecom.repository.CategoryRepository;
import com.cotiviti.ecom.repository.ItemRepository;
import com.cotiviti.ecom.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public ItemDTO addItem(ItemDTO itemDTO, Integer categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        Item item = dtoToClass(itemDTO);
        item.setCategory(category);
        Item saved = itemRepository.save(item);
        return classToDTO(saved);
    }

    @Override
    public void deleteItem(Integer itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item", "itemId", itemId));
        itemRepository.delete(item);
    }

    @Override
    public List<ItemDTO> getCategoryItems(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
        List<Item> items = category.getItems();
        return items.stream()
                .map((item) -> this.modelMapper.map(item, ItemDTO.class))
                .collect(Collectors.toList());
    }

    private Item dtoToClass(ItemDTO dto) {
        return modelMapper.map(dto, Item.class);
    }

    private ItemDTO classToDTO(Item item) {
        return modelMapper.map(item, ItemDTO.class);
    }

}

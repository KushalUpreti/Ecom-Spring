package com.cotiviti.ecom.dto;

import com.cotiviti.ecom.model.Item;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class CategoryDTO {
    private int id;

    @NotEmpty
    private String title;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    private List<Item> items;

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", items=" + items +
                '}';
    }
}

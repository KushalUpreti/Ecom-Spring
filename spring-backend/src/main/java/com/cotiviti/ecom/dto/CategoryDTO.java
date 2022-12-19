package com.cotiviti.ecom.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CategoryDTO {
    private int id;

    @NotEmpty
    private String title;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "title='" + title + '\'' +
                '}';
    }
}

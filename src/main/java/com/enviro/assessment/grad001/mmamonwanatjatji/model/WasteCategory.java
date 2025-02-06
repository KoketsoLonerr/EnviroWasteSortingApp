package com.enviro.assessment.grad001.mmamonwanatjatji.model;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Entity
@Data

public class WasteCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Category name is required")
    private String categoryName;

    @NotBlank(message = "Category description is required")
    private String categoryDescription;

    @NotBlank(message = "Category type is required")
    private String categoryType;

    @NotBlank(message = "Disposal gudeline is required")
    private String disposalGuideline;

    @NotBlank(message = "Recycling Tips is required")
    private String recyclingTips;
}

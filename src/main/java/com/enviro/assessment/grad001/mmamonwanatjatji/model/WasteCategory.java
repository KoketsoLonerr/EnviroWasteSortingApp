package com.enviro.assessment.grad001.mmamonwanatjatji.model;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;

// Marks this class as a JPA entity for persistence in the database
@Entity
 // Lombok annotation to generate getters, setters, equals, hashCode, and toString methods automatically
@Data

public class WasteCategory {
    @Id   // Specifies the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // Automatically generates a value for the primary key
    private Long id;   // The unique identifier for each waste category


    @NotBlank(message = "Category name is required")    // Validates that the category name cannot be blank
    private String categoryName;// The name of the waste category

    @NotBlank(message = "Category description is required")  // Validates that the category description cannot be blank
    private String categoryDescription; // A description of the waste category

    @NotBlank(message = "Category type is required") // Validates that the category type cannot be blank
    private String categoryType; // The type or classification of the waste category (e.g., plastic, organic)

    @NotBlank(message = "Disposal gudeline is required")  // Validates that the disposal guideline cannot be blank
    private String disposalGuideline; // The recommended method of disposal for the waste category

    @NotBlank(message = "Recycling Tips is required")  // Validates that recycling tips cannot be blank
    private String recyclingTips;  // Tips for recycling this waste category
}

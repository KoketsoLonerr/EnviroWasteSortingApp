package com.enviro.assessment.grad001.mmamonwanatjatji.repository;

import com.enviro.assessment.grad001.mmamonwanatjatji.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface that extends JpaRepository to handle CRUD operations for WasteCategory
public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {
    
}

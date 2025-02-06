package com.enviro.assessment.grad001.mmamonwanatjatji.service;

import com.enviro.assessment.grad001.mmamonwanatjatji.model.WasteCategory;
import com.enviro.assessment.grad001.mmamonwanatjatji.repository.WasteCategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WasteCategoryService {

    // Injecting the repository to interact with the database
    private final WasteCategoryRepository wasteCategoryRepository;
    
    // Constructor-based dependency injection for WasteCategoryRepositoryy
    public WasteCategoryService(WasteCategoryRepository wasteCategoryRepository) {
        this.wasteCategoryRepository = wasteCategoryRepository;
    }

     // Method to get all waste categories from the database
    public List<WasteCategory> getAllWasteCategories() {
        return wasteCategoryRepository.findAll();  // Retrieve all records from the repository
    }

     // Method to get a waste category by its ID, throws exception if not found
    //If no category found, throws exception with a relevant message
    public WasteCategory getWasteCategoryById(Long id) {
        return wasteCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Waste Category not found with id: " + id));
    }

    // Method to add a new waste category to the database
    public WasteCategory addWasteCategory(WasteCategory wasteCategory) {
        return wasteCategoryRepository.save(wasteCategory); // Save the new waste category to the repository
    }


    // Method to update an existing waste category in the database
    // Check if the waste category exists in the repository
    // Throws exception if the category doesn't exist
    public WasteCategory updateWasteCategory(WasteCategory wasteCategory) {
        if (!wasteCategoryRepository.existsById(wasteCategory.getId())) {
            throw new RuntimeException("Waste Category not found with id: " + wasteCategory.getId());
        }
        // Save the updated category to the repository
        return wasteCategoryRepository.save(wasteCategory);
    }

     // Method to delete a waste category by its ID, using transaction management
    @Transactional
    public void deleteWasteCategory(Long id) {
        // Check if the waste category exists before attempting to delete
        // Throws exception if the category doesn't exist
        if (!wasteCategoryRepository.existsById(id)) {
            throw new RuntimeException("Cannot delete. Waste Category not found with id: " + id);
        }
        wasteCategoryRepository.deleteById(id);  // Deletes the waste category from the repository
    }
}

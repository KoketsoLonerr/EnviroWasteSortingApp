package com.enviro.assessment.grad001.mmamonwanatjatji.service;

import com.enviro.assessment.grad001.mmamonwanatjatji.model.WasteCategory;
import com.enviro.assessment.grad001.mmamonwanatjatji.repository.WasteCategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WasteCategoryService {

    private final WasteCategoryRepository wasteCategoryRepository;

    public WasteCategoryService(WasteCategoryRepository wasteCategoryRepository) {
        this.wasteCategoryRepository = wasteCategoryRepository;
    }

    public List<WasteCategory> getAllWasteCategories() {
        return wasteCategoryRepository.findAll();
    }

    public WasteCategory getWasteCategoryById(Long id) {
        return wasteCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Waste Category not found with id: " + id));
    }

    public WasteCategory addWasteCategory(WasteCategory wasteCategory) {
        return wasteCategoryRepository.save(wasteCategory);
    }

    public WasteCategory updateWasteCategory(WasteCategory wasteCategory) {
        if (!wasteCategoryRepository.existsById(wasteCategory.getId())) {
            throw new RuntimeException("Waste Category not found with id: " + wasteCategory.getId());
        }
        return wasteCategoryRepository.save(wasteCategory);
    }

    @Transactional
    public void deleteWasteCategory(Long id) {
        if (!wasteCategoryRepository.existsById(id)) {
            throw new RuntimeException("Cannot delete. Waste Category not found with id: " + id);
        }
        wasteCategoryRepository.deleteById(id);
    }
}

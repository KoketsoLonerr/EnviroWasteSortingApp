package com.enviro.assessment.grad001.mmamonwanatjatji.controller;

import com.enviro.assessment.grad001.mmamonwanatjatji.model.WasteCategory;
import com.enviro.assessment.grad001.mmamonwanatjatji.service.WasteCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/wasteCategory")
public class WasteCategoryController {

    @Autowired
    private final WasteCategoryService wasteCategoryService;



    public WasteCategoryController(WasteCategoryService wasteCategoryService) {
        this.wasteCategoryService = wasteCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllWasteCategories() {
        return ResponseEntity.ok(wasteCategoryService.getAllWasteCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getWasteCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(wasteCategoryService.getWasteCategoryById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WasteCategory addWasteCategory(@RequestBody WasteCategory wasteCategory) {
        return wasteCategoryService.addWasteCategory(wasteCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateWasteCategory(@PathVariable Long id, @RequestBody WasteCategory wasteCategory) {
        wasteCategory.setId(id); // Ensure the ID from path matches the body
        return ResponseEntity.ok(wasteCategoryService.updateWasteCategory(wasteCategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWasteCategory(@PathVariable Long id) {
        wasteCategoryService.deleteWasteCategory(id);
        return ResponseEntity.noContent().build();
    }
}

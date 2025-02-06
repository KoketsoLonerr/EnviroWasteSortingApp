package com.enviro.assessment.grad001.mmamonwanatjatji.controller;

import com.enviro.assessment.grad001.mmamonwanatjatji.model.WasteCategory;
import com.enviro.assessment.grad001.mmamonwanatjatji.service.WasteCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// Marks this class as a REST controller for handling HTTP requests
@RestController
@RequestMapping("/api/v1/wasteCategory") // Specifies the base URL for all methods in this controller
public class WasteCategoryController {

    // Injecting the WasteCategoryService to handle business logic
    @Autowired
    private final WasteCategoryService wasteCategoryService;


    // Constructor to initialize WasteCategoryService
    public WasteCategoryController(WasteCategoryService wasteCategoryService) {
        this.wasteCategoryService = wasteCategoryService;
    }
     // Endpoint to get all waste categories from the database
    // Maps GET requests to this method
    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllWasteCategories() {
        // Returns a list of waste categories as a response
        return ResponseEntity.ok(wasteCategoryService.getAllWasteCategories());
    }


    // Endpoint to get a specific waste category by its ID
    // Maps GET requests with an ID paramete
    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getWasteCategoryById(@PathVariable Long id) {
        // Returns the waste category with the given ID
        return ResponseEntity.ok(wasteCategoryService.getWasteCategoryById(id));
    }

    //Endpoint to create a new waste category
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //sets theb response status to CREATED(201) 
    public WasteCategory addWasteCategory(@RequestBody WasteCategory wasteCategory) {
        return wasteCategoryService.addWasteCategory(wasteCategory); // // Passes the waste category to the service to save it
    }

     // Endpoint to update an existing waste category
     // Maps PUT requests with an ID parameter
    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateWasteCategory(@PathVariable Long id, @RequestBody WasteCategory wasteCategory) {
        wasteCategory.setId(id); // Ensure the ID from path matches the request body
        return ResponseEntity.ok(wasteCategoryService.updateWasteCategory(wasteCategory));
    }

    // Endpoint to delete a waste category by its ID
    @DeleteMapping("/{id}") // Maps DELETE requests with an ID parameter
    public ResponseEntity<Void> deleteWasteCategory(@PathVariable Long id) {
        wasteCategoryService.deleteWasteCategory(id);  // Deletes the waste category with the given ID
        return ResponseEntity.noContent().build(); //// Returns a 204 No Content status to indicate successful deletion
    }
}

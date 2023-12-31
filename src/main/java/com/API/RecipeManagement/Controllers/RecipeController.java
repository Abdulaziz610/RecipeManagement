package com.API.RecipeManagement.Controllers;


import com.API.RecipeManagement.Models.RecipesModel;
import com.API.RecipeManagement.Repository.RecipeRepo;
import com.API.RecipeManagement.RequestObjects.RatingRequest;
import com.API.RecipeManagement.RequestObjects.RecipeRequest;
import com.API.RecipeManagement.ResponseObjects.RecipeResponse;
import com.API.RecipeManagement.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "recipe")
public class RecipeController {
    @Autowired
    RecipeService recipeService;
    @Autowired
    RecipeRepo recipeRepo;

    /*
     * Post Request: For the recipe:
     * Name, ingredients, instructions, cooking_time
     *
     * */
    @PostMapping(value = "/api/recipes")
    public String savingRecipe(@RequestBody RecipeRequest recipeRequest) {
        recipeService.savingRecipe(recipeRequest);
        return "Successfully Saved The Recipe";
    }

    @GetMapping(value = "/api/recipes")
    public RecipeResponse getRecipeById(@RequestParam Integer idOfRecipe) {
        return recipeService.getRecipeById(idOfRecipe);
    }

    /*
     * Update the recipe for any change
     * */
    @PutMapping("/api/recipes/{recipeId}")
    public ResponseEntity<String> updateRecipe(@PathVariable Integer recipeId, @RequestBody RecipeRequest recipeRequest) {
        RecipesModel existingRecipe = recipeRepo.findById(recipeId)
                .orElseThrow(() -> new IllegalArgumentException("Recipe not found with id: " + recipeId));
        existingRecipe = RecipeRequest.convertToEntity(existingRecipe, recipeRequest);
        existingRecipe.setUpdateDate(new Date());
        recipeRepo.save(existingRecipe);
        return ResponseEntity.ok("Successfully Updated The Recipe");
    }


    /*
     * Search for a recipe by a keyword
     * */
    @GetMapping("/api/recipes/search")
    public Map<String, List<RecipeResponse>> searchRecipesByKeywords(@RequestParam String keywords) {
        List<RecipeResponse> matchingRecipes = recipeService.searchRecipesByKeywords(keywords);
        Map<String, List<RecipeResponse>> response = new HashMap<>();
        response.put("recipes", matchingRecipes);
        return response;
    }

    /*
     * Delete the recipe by the ID
     * */
    @DeleteMapping("/api/recipes/{recipeId}")
    public String deleteRecipe(@PathVariable Integer recipeId) {
        recipeService.deleteRecipe(recipeId);
        return "Successfully Delete The Recipe";
    }

    @PostMapping(value = "/api/recipes/{recipeId}/rating")
    public ResponseEntity<String> rateRecipe(@PathVariable Integer recipeId, @RequestBody RatingRequest ratingRequest) {
        return recipeService.rateRecipe(recipeId, ratingRequest);
    }

}

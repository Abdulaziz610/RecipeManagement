package com.API.RecipeManagement.Controllers;


import com.API.RecipeManagement.RequestObjects.RecipeRequest;
import com.API.RecipeManagement.ResponseObjects.RecipeResponse;
import com.API.RecipeManagement.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "recipe")
public class RecipeController {
    @Autowired
    RecipeService recipeService;

    @PostMapping(value = "/api/recipes")
    public String savingRecipe(@RequestBody RecipeRequest recipeRequest) {
        recipeService.savingRecipe(recipeRequest);
        return "Successfully Saved The Recipe";
    }


    @GetMapping(value = "/api/recipes")
    public RecipeResponse getRecipeById(@RequestParam Integer idOfRecipe) {
        return recipeService.getRecipeById(idOfRecipe);
    }


    @GetMapping("/api/recipes/search")
    public Map<String, List<RecipeResponse>> searchRecipesByKeywords(@RequestParam String keywords) {
        List<RecipeResponse> matchingRecipes = recipeService.searchRecipesByKeywords(keywords);
        Map<String, List<RecipeResponse>> response = new HashMap<>();
        response.put("recipes", matchingRecipes);
        return response;
    }


    @DeleteMapping("/api/recipes/{recipeId}")
    public String deleteRecipe(@PathVariable Integer recipeId) {
        recipeService.deleteRecipe(recipeId);
        return "Successfully Delete The Recipe";
    }
}

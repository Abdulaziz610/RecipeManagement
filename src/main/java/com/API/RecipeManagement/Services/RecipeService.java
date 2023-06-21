package com.API.RecipeManagement.Services;


import com.API.RecipeManagement.Models.RecipesModel;
import com.API.RecipeManagement.Repository.RecipeRepo;
import com.API.RecipeManagement.RequestObjects.RatingRequest;
import com.API.RecipeManagement.RequestObjects.RecipeRequest;
import com.API.RecipeManagement.ResponseObjects.RecipeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    @Autowired
    RecipeRepo recipeRepo;



    /*
    *
    * Saves a new recipe based on the provided recipe request.
    * Creates a new RecipesModel object.
    * Returns a success message upon successful saving.
    *
    * */
    public String savingRecipe(RecipeRequest recipeRequest) {
        RecipesModel newRecipe = new RecipesModel();
        newRecipe = RecipeRequest.convertToEntity(newRecipe, recipeRequest);
        newRecipe.setNewDate(new Date());
        newRecipe.setIsActive(Boolean.TRUE);
        recipeRepo.save(newRecipe);
        return "Successfully Saved The Recipe";
    }


    /*
    * Getting the recipes by ID
    * */
    public RecipeResponse getRecipeById(Integer idOfRecipe) {
        return RecipeResponse.convertToResponse(recipeRepo.findById(idOfRecipe).get());
    }


    /*
    * Search for a recipe by a keywords
    * */

    public List<RecipeResponse> searchRecipesByKeywords(String keywords) {
        List<RecipesModel> matchingRecipes = recipeRepo.findAllByNameContainingIgnoreCase(keywords);
        return matchingRecipes.stream()
                .map(RecipeResponse::convertToResponse)
                .collect(Collectors.toList());
    }


    /*
    *
    * Delete a recipe by ID
    * Returns a success message upon successful delete.
    * */
    public String deleteRecipe(Integer recipeId) {
        recipeRepo.deleteById(recipeId);
        return "Successfully Deleted The Recipe";

    }


    /*
    *
    * Rates a recipe identified by the given recipe ID based on the provided rating request.
    * Returns a success message upon successful Rated recipe.
    * */

    public ResponseEntity<String> rateRecipe(Integer recipeId, RatingRequest ratingRequest) {
        Optional<RecipesModel> optionalRecipe = recipeRepo.findById(recipeId);
        if (optionalRecipe.isPresent()) {
            RecipesModel recipe = optionalRecipe.get();
            int rating = ratingRequest.getRating();
            recipe.setRating(rating);
            recipeRepo.save(recipe);
            return ResponseEntity.ok("Successfully Rated The Recipe");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

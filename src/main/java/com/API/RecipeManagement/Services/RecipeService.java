package com.API.RecipeManagement.Services;


import com.API.RecipeManagement.Models.RecipesModel;
import com.API.RecipeManagement.Repository.RecipeRepo;
import com.API.RecipeManagement.RequestObjects.RecipeRequest;
import com.API.RecipeManagement.ResponseObjects.RecipeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RecipeService {

    @Autowired
    RecipeRepo recipeRepo;

    public String savingRecipe(RecipeRequest recipeRequest) {
        RecipesModel newRecipe = new RecipesModel();
        newRecipe = RecipeRequest.convertToEntity(newRecipe, recipeRequest);
        newRecipe.setNewDate(new Date());
        newRecipe.setIsActive(Boolean.TRUE);
        recipeRepo.save(newRecipe);

        return "Successfully Saved The Recipe";
    }

    public RecipeResponse getRecipeById(Integer idOfRecipe){

    }
}

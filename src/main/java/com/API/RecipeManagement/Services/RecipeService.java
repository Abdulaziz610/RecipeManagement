package com.API.RecipeManagement.Services;


import com.API.RecipeManagement.Models.RecipesModel;
import com.API.RecipeManagement.Repository.RecipeRepo;
import com.API.RecipeManagement.RequestObjects.RecipeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    @Autowired
    RecipeRepo  recipeRepo;

    public String savingRecipe(RecipeRequest recipeRequest){
        RecipesModel newRecipe = new RecipesModel();
        newRecipe= RecipeRequest.convertToEntity(newRecipe,recipeRequest);
        return  "Successfully Saved The Recipe";

    }
}

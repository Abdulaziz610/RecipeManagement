package com.API.RecipeManagement.ResponseObjects;


import com.API.RecipeManagement.Models.RecipesModel;
import com.API.RecipeManagement.RequestObjects.RecipeRequest;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RecipeResponse {
    String  recipeName;
    List<String> recipeIngredients;
    String recipeInstructions;
    Integer recipeCookingTime;

    public static RecipeResponse convertToResponse(RecipesModel entity){

    }









}

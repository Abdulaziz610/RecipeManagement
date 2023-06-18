package com.API.RecipeManagement.ResponseObjects;


import com.API.RecipeManagement.Models.RecipesModel;
import com.API.RecipeManagement.RequestObjects.RecipeRequest;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RecipeResponse {
    Integer id;
    String recipeName;
    List<String> recipeIngredients;
    String recipeInstructions;
    Integer recipeCookingTime;

    public static RecipeResponse convertToResponse(RecipesModel entity) {
        return RecipeResponse.builder()
                .id(entity.getId())
                .recipeIngredients(entity.getIngredient())
                .recipeInstructions(entity.getInstruction())
                .recipeCookingTime(entity.getCookingTime())
                .build();

    }

}

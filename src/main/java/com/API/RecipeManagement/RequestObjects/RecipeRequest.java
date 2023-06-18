package com.API.RecipeManagement.RequestObjects;

import com.API.RecipeManagement.Models.RecipesModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;



@Data
@Getter
@Setter

public class RecipeRequest {
String  recipeName;
List<String> recipeIngredients;
String recipeInstructions;
Integer recipeCookingTime;


    public static RecipesModel convertToEntity(RecipesModel entity, RecipeRequest request){



    }







}

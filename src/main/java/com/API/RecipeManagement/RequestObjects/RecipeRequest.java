package com.API.RecipeManagement.RequestObjects;

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

}

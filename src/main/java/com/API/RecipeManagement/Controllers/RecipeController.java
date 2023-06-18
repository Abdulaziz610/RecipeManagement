package com.API.RecipeManagement.Controllers;


import com.API.RecipeManagement.RequestObjects.RecipeRequest;
import com.API.RecipeManagement.ResponseObjects.RecipeResponse;
import com.API.RecipeManagement.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    }
}

package com.API.RecipeManagement.Controllers;


import com.API.RecipeManagement.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "recipe")
public class RecipeController {
    @Autowired
    RecipeService recipeService;

    @PostMapping(value = "/api/recipes")
    @GetMapping(value = "/api/recipes")


}

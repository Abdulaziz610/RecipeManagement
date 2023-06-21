package com.API.RecipeManagement.Repository;


import com.API.RecipeManagement.Models.RecipesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepo extends JpaRepository<RecipesModel, Integer> {
    /*The name of the method
     * this method is to search for a recipe by there ID
     * */
    List<RecipesModel> findAllByNameContainingIgnoreCase(String keywords);
}

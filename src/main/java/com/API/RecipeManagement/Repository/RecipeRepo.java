package com.API.RecipeManagement.Repository;


import com.API.RecipeManagement.Models.RecipesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepo extends JpaRepository<RecipesModel, Integer> {


}

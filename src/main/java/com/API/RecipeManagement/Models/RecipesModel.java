package com.API.RecipeManagement.Models;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
public class RecipesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    Integer id;
    String name;
    List<String> ingredient;
    String instruction;
    Integer cookingTime;


}

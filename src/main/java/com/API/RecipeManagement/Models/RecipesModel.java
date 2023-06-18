package com.API.RecipeManagement.Models;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class RecipesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    Integer id;
    String name;
    @ElementCollection
    List<String> ingredients;
    String instructions;
    Integer cookingTime;
    Date newDate;
    Date updateDate;
    Boolean isActive;


}

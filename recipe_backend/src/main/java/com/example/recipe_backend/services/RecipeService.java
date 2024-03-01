package com.example.recipe_backend.services;

import com.example.recipe_backend.entity.Recipe;
import com.example.recipe_backend.pojo.RecipePojo;
import com.example.recipe_backend.repository.RecipeRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RecipeService {
    private final RecipeRepo recipeRepo;
    public RecipeService(RecipeRepo recipeRepo) {
        this.recipeRepo = recipeRepo;
    }

    public Recipe createRecipe(RecipePojo recipePojo){
        if (recipeRepo.findByTitle(recipePojo.getTitle()).isPresent()) return new Recipe();
        Recipe recipe=new Recipe(recipePojo.getTitle(),recipePojo.getIngredients(),recipePojo.getMethod(),recipePojo.getCookingTime());
        return recipeRepo.save(recipe);
    }

    public void deleteRecipe(Integer recipeId){
        if (recipeRepo.existsById(recipeId)){
            recipeRepo.delete(recipeRepo.findById(recipeId).get());
            return;
        }
        throw new NoSuchElementException("Recipe not found");
    }

    public RecipePojo getRecipe(Integer recipeId){
        Recipe recipe=recipeRepo.findById(recipeId).orElseThrow(()->new NoSuchElementException("Recipe Not Found"));
        return new RecipePojo(recipe.getTitle(), new ArrayList<>(recipe.getIngredients()), recipe.getMethod(), recipe.getCookingTime());

    }

    public List<Recipe> getAll(){
        return recipeRepo.findAll();
    }

}

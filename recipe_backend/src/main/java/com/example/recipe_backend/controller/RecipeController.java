package com.example.recipe_backend.controller;

import com.example.recipe_backend.entity.Recipe;
import com.example.recipe_backend.pojo.RecipePojo;
import com.example.recipe_backend.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/recipe")
@CrossOrigin("*")
public class RecipeController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> addRecipe(@RequestBody RecipePojo recipePojo){
        Recipe recipe =recipeService.createRecipe(recipePojo);
        if (recipe.getTitle().isBlank())  return new ResponseEntity<>("Recipe Not saved", HttpStatus.CONFLICT);
        return new ResponseEntity<>("Recipe saved", HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRecipe(@PathVariable Integer id){
        try{
            recipeService.deleteRecipe(id);
            return new ResponseEntity<>("Recipe saved", HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipePojo> getRecipe(@PathVariable Integer id){
        try{
            RecipePojo recipePojo=recipeService.getRecipe(id);
            return new ResponseEntity<>(recipePojo, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(new RecipePojo(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/")
    public List<Recipe> getAllRecipe(){
        return  recipeService.getAll();
    }
}

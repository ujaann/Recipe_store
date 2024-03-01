package com.example.recipe_backend.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "recipes") // Define the table name explicitly
public class Recipe {
    public Recipe() {
    }

    public Recipe(String title, List<String> ingredients, String method, String cookingTime) {
        this.title = title;
        this.method = method;
        this.cookingTime = cookingTime;
        this.ingredients = new HashSet<>(ingredients);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Using Long instead of long for compatibility with JPA

    @Column(nullable = false,unique = true) // Define column constraints
    private String title;

    @ElementCollection
    @CollectionTable(name = "recipe_ingredients", joinColumns = @JoinColumn(name = "recipe_id"))
    @Column(name = "ingredient") // Define the column name for the ingredients
    private Set<String> ingredients = new HashSet<>();

    @Column(length = 6000)
    private String method;

    @Column(name = "cooking_time") // Define the column name explicitly
    private String cookingTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(String cookingTime) {
        this.cookingTime = cookingTime;
    }
}

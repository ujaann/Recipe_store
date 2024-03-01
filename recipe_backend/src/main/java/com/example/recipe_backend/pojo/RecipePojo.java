package com.example.recipe_backend.pojo;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.JoinColumn;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecipePojo {
    private String title;
    private List<String> ingredients;
    private String method;
    private String cookingTime;

    public RecipePojo() {
        super();
    }

    public RecipePojo(String title, List<String> ingredients, String method, String cookingTime) {
        this.title = title;
        this.ingredients = ingredients;
        this.method = method;
        this.cookingTime = cookingTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
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

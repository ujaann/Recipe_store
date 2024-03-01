package com.example.recipe_backend.repository;

import com.example.recipe_backend.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe,Integer> {
    Optional<Recipe> findByTitle(String title);
}

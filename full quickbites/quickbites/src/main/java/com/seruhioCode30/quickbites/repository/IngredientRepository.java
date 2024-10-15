package com.seruhioCode30.quickbites.repository;

import com.seruhioCode30.quickbites.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository <Ingredient, Long> {
}

/**
 * -----------------------------------------------------------------------------
 * File Name: Recipe.java
 * Project: The Brewery Problem
 * Description:
 *     Defines the blueprint for producing a particular type of beer or brew.
 *     Each Recipe specifies a name, target temperature, expected gravity
 *     checkpoints, and a list of {@link RecipeRequirement} objects describing
 *     the required ingredients and their quantities.
 *
 *     Recipes are stored within the {@link RecipeLibrary} and referenced
 *     during batch creation in the {@link brewery.app.BrewerySystem}. This
 *     class provides utility methods to add and retrieve individual ingredient
 *     requirements for validation and inventory management.
 *
 * Author: Yue Wu
 * Course: CS5010 - Programming Design Paradigm
 * Date: October, 6, 2025
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */
package brewery.recipes;

import java.util.*;

public class Recipe {
    private final String name;
    private final double targetTempC;
    private final Map<String, Double> gravityTargets = new HashMap<>();
    private final List<RecipeRequirement> requirements = new ArrayList<>();

    // Constructor to initialize the recipe with a name and target temperature
    public Recipe(String name, double targetTempC) {
        this.name = name;
        this.targetTempC = targetTempC;
    }

    // Method to add a gravity target checkpoint
    public String name() {
        return name;
    }
    public double targetTempC() {
        return targetTempC;
    }
    public List<RecipeRequirement> requirements() {
        return Collections.unmodifiableList(requirements);
    }

    public void addRequirement(RecipeRequirement req) {
        requirements.add(req);
    }

    public Optional<RecipeRequirement> getRequirement(Ingredient ing) {
        return requirements.stream().filter(r -> r.ingredient().equals(ing)).findFirst();
    }
}

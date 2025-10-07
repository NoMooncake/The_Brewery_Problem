/**
 * -----------------------------------------------------------------------------
 * File Name: RecipeRequirement.java
 * Project: The Brewery Problem
 * Description:
 *     Represents a single ingredient requirement within a {@link Recipe}.
 *     Each requirement specifies an {@link Ingredient}, the quantity needed,
 *     and the measurement unit (e.g., kilograms, liters, grams).
 *
 *     RecipeRequirement objects are aggregated by the {@link Recipe} class
 *     to define the complete list of inputs necessary for a brewing batch.
 *     They are also referenced by the {@link brewery.inventory.Inventory}
 *     during ingredient validation and deduction.
 *
 * Author: Yue Wu
 * Course: CS5010 - Programming Design Paradigm
 * Date: October, 6, 2025
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */

package brewery.recipes;

public class RecipeRequirement {
    private final Ingredient ingredient;
    private final double amount;
    private final String unit;

    // Constructor to initialize the recipe requirement with ingredient, amount, and unit
    public RecipeRequirement(Ingredient ingredient, double amount, String unit) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.unit = unit;
    }

    // Getters for the fields
    public Ingredient ingredient() { return ingredient; }
    public double amount() { return amount; }
    public String unit() { return unit; }
}

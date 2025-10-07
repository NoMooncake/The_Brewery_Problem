/**
 * -----------------------------------------------------------------------------
 * File Name: Ingredient.java
 * Project: The Brewery Problem
 * Description:
 *     Represents a basic brewing ingredient identified by its name. This
 *     record serves as a lightweight, immutable data structure used within
 *     recipes and inventory tracking. Typical examples include malt, hops,
 *     yeast, and water.
 *
 *     Ingredients are referenced by {@link Recipe}, {@link RecipeRequirement},
 *     and {@link brewery.inventory.InventoryItem} to maintain consistency
 *     across the brewing process.
 *
 * Author: Yue Wu
 * Course: CS5010 - Programming Design Paradigm
 * Date: October, 6, 2025
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */

package brewery.recipes;

public record Ingredient(String name) {

}

/**
 * -----------------------------------------------------------------------------
 * File Name: RecipeLibrary.java
 * Project: The Brewery Problem
 * Description:
 *     Acts as a centralized repository for all {@link Recipe} objects used in
 *     the brewery. Each recipe is indexed by name and can be added, retrieved,
 *     or validated through this class.
 *
 *     The RecipeLibrary provides recipe lookup services to the
 *     {@link brewery.app.BrewerySystem} when new batches are created or
 *     when ingredient requirements need to be checked against inventory.
 *     It ensures consistent access to recipe definitions across the system.
 *
 * Author: Yue Wu
 * Course: CS5010 - Programming Design Paradigm
 * Date: October, 6, 2025
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */

package brewery.recipes;

import java.util.HashMap;
import java.util.Map;

public class RecipeLibrary {
    private final Map<String, Recipe> recipes = new HashMap<>();

    // Method to add a new recipe to the library
    public void addRecipe(Recipe r) { recipes.put(r.name(), r); }
    public Recipe get(String name) {
        Recipe r = recipes.get(name);
        if (r == null) throw new IllegalArgumentException("Recipe not found: " + name);
        return r;
    }
}

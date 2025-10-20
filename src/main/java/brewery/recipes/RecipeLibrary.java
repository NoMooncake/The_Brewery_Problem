/**
 * -----------------------------------------------------------------------------
 * File Name: RecipeLibrary.java
 * Project: The Brewery Problem
 * Description:
 *     Central repository for {@link Recipe} definitions used by the Brewery System.
 *     This implementation avoids external collection libraries (e.g., HashMap)
 *     by storing recipes in a lightweight, array-backed structure and performing
 *     linear searches for lookups.
 *
 *     Responsibilities:
 *     - Add new recipes with uniqueness by name.
 *     - Retrieve a recipe by its name.
 *     - Provide a read-only snapshot of all recipes.
 *
 * Design notes:
 * <ul>
 *   <li>No external containers (HashMap/LinkedList) to satisfy assignment constraints.</li>
 *   <li>Methods follow single-responsibility to keep WMC low.</li>
 *   <li>No I/O; presentation is handled elsewhere.</li>
 * </ul>
 *
 * Author: Yue Wu
 * Course: CS5010 – Programming Design Paradigm
 * Date: October, 19, 2025
 * Version: 2.0
 * -----------------------------------------------------------------------------
 */

package brewery.recipes;

/**
 * Array-backed library of {@link Recipe} objects with uniqueness enforced by name.
 */
public class RecipeLibrary {
    /** Internal dynamic array for storing recipes. */
    private Recipe[] recipes = new Recipe[8];
    /** Number of valid entries in {@link #recipes}. */
    private int count = 0;
    /**
     * Retrieves a recipe by its name.
     * This is an alias for {@link #getByName(String)}.
     *
     * @param name the recipe name to search for
     * @return the matching {@link Recipe}
     * @throws IllegalArgumentException if no recipe with the given name exists
     * @throws NullPointerException if {@code name} is null
     */
    public Recipe get(String name) {
        return getByName(name);
    }

    /**
     * Adds a new recipe to the library. The recipe name must be unique.
     *
     * @param r the recipe to add (must not be {@code null})
     * @throws IllegalArgumentException if a recipe with the same name already exists
     * @throws NullPointerException if {@code r} or {@code r.name()} is null
     */
    public void addRecipe(Recipe r) {
        if (r == null || r.name() == null) {
            throw new NullPointerException("Recipe and recipe.name must not be null");
        }
        if (indexOfName(r.name()) >= 0) {
            throw new IllegalArgumentException("Duplicate recipe name: " + r.name());
        }
        ensureCapacity();
        recipes[count++] = r;
    }

    /**
     * Retrieves a recipe by its name.
     *
     * @param name the recipe name to search for
     * @return the matching {@link Recipe}
     * @throws IllegalArgumentException if no recipe with the given name exists
     * @throws NullPointerException if {@code name} is null
     */
    public Recipe getByName(String name) {
        if (name == null) throw new NullPointerException("name must not be null");
        int idx = indexOfName(name);
        if (idx < 0) throw new IllegalArgumentException("Recipe not found: " + name);
        return recipes[idx];
    }

    /**
     * Checks whether a recipe with the given name exists.
     *
     * @param name the recipe name
     * @return {@code true} if present; otherwise {@code false}
     */
    public boolean has(String name) {
        return name != null && indexOfName(name) >= 0;
    }

    /**
     * Returns a snapshot array of all recipes currently stored.
     * The returned array is a copy and can be safely iterated without affecting the library.
     *
     * @return an array containing all {@link Recipe} entries
     */
    public Recipe[] all() {
        Recipe[] snapshot = new Recipe[count];
        System.arraycopy(recipes, 0, snapshot, 0, count);
        return snapshot;
    }

    // -------------------------------------------------------------------------
    // Private helpers
    // -------------------------------------------------------------------------

    /**
     * Finds the index of a recipe by name using linear search.
     *
     * @param name the recipe name
     * @return index if found; otherwise {@code -1}
     */
    private int indexOfName(String name) {
        for (int i = 0; i < count; i++) {
            // Assuming Recipe.name() defines equality semantics for identity
            if (name.equals(recipes[i].name())) return i;
        }
        return -1;
    }

    /** Ensures internal capacity for at least one additional recipe. */
    private void ensureCapacity() {
        if (count < recipes.length) return;
        Recipe[] next = new Recipe[recipes.length * 2];
        System.arraycopy(recipes, 0, next, 0, count);
        recipes = next;
    }
}

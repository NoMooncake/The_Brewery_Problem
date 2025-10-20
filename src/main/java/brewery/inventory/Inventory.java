/**
 * -----------------------------------------------------------------------------
 * File Name: Inventory.java
 * Project: The Brewery Problem
 * Description:
 *     Maintains ingredient quantities in the brewery’s storage and provides
 *     methods for adding, checking, and consuming ingredients. This version
 *     replaces library collections with a lightweight array-based structure
 *     to conform to the assignment restrictions (no external containers).
 *
 *     Each InventoryItem entry tracks a single {@link brewery.recipes.Ingredient},
 *     its current quantity, and unit of measurement. The Inventory ensures that
 *     additions and consumptions maintain data consistency and that no negative
 *     quantities occur.
 *
 * Design notes:
 * <ul>
 *   <li>No use of HashMap or other external library containers.</li>
 *   <li>Each public method performs a single, well-defined operation (low WMC).</li>
 *   <li>Pure data manipulation—no console output or user I/O occurs here.</li>
 * </ul>
 *
 * Author: Yue Wu
 * Course: CS5010 – Programming Design Paradigm
 * Date: October, 19, 2025
 * Version: 2.1
 * -----------------------------------------------------------------------------
 */
package brewery.inventory;

import brewery.recipes.Ingredient;
import brewery.recipes.Recipe;
import brewery.recipes.RecipeRequirement;

/**
 * Represents the brewery’s ingredient inventory.
 * <p>
 * Stores all {@link InventoryItem} objects in a simple expandable array and
 * provides single-responsibility methods for manipulating stock levels.
 */
public class Inventory {

    /** Internal dynamic array to hold InventoryItem objects. */
    private InventoryItem[] items = new InventoryItem[10];
    /** Current count of valid entries. */
    private int count = 0;

    /**
     * Adds a specified amount of an ingredient to the inventory.
     * If the ingredient already exists, its quantity is increased.
     * Otherwise, a new {@link InventoryItem} entry is created.
     */
    public void add(Ingredient ing, double amt, String unit) {
        InventoryItem existing = findItem(ing);
        if (existing != null) { existing.add(amt); return; }
        ensureCapacity();
        items[count++] = new InventoryItem(ing, amt, unit);
    }

    /** @return true if inventory has at least the given amount of the ingredient. */
    public boolean has(Ingredient ing, double amt) {
        InventoryItem item = findItem(ing);
        return item != null && item.quantity() >= amt;
    }

    /**
     * Attempts to consume a given amount of an ingredient.
     * @return true if successfully deducted; otherwise false.
     */
    public boolean take(Ingredient ing, double amt) {
        InventoryItem item = findItem(ing);
        return item != null && item.take(amt);
    }

    /**
     * Sets a reorder threshold for a specific ingredient.
     * @return true if the ingredient exists and threshold set; otherwise false.
     */
    public boolean setThreshold(Ingredient ing, double threshold) {
        InventoryItem item = findItem(ing);
        if (item == null) return false;
        item.setThreshold(threshold);
        return true;
    }

    /**
     * Checks if inventory can satisfy a recipe for target bottles.
     * Units must match exactly (string equality).
     */
    public boolean hasFor(brewery.recipes.Recipe recipe, int targetBottles) {
        if (recipe == null || recipe.yieldBottles() <= 0 || targetBottles <= 0) return false;
        double scale = ((double) targetBottles) / recipe.yieldBottles();
        java.util.List<brewery.recipes.RecipeRequirement> reqs = recipe.requirements();
        for (int i = 0; i < reqs.size(); i++) {
            brewery.recipes.RecipeRequirement r = reqs.get(i);
            InventoryItem it = findItem(r.ingredient());
            if (it == null) return false;
            if (!it.unit().equals(r.unit())) return false;
            if (it.quantity() < r.amount() * scale) return false;
        }
        return true;
    }

    /**
     * Reserves (deducts) ingredients for a recipe if possible.
     * All-or-nothing: returns false and does not deduct if any requirement fails.
     */
    public boolean reserveFor(brewery.recipes.Recipe recipe, int targetBottles) {
        if (!hasFor(recipe, targetBottles)) return false;
        double scale = ((double) targetBottles) / recipe.yieldBottles();
        java.util.List<brewery.recipes.RecipeRequirement> reqs = recipe.requirements();
        for (int i = 0; i < reqs.size(); i++) {
            brewery.recipes.RecipeRequirement r = reqs.get(i);
            double need = r.amount() * scale;
            InventoryItem it = findItem(r.ingredient());
            it.take(need); // findItem guaranteed non-null by hasFor check
        }
        return true;
    }

    /**
     * Returns a fixed-size array of items whose quantity is at or below threshold.
     * Used by monitoring/ordering to trigger replenishment workflows.
     */
    public InventoryItem[] reorderCheck() {
        int n = 0;
        for (int i = 0; i < count; i++) if (items[i].needsReorder()) n++;
        InventoryItem[] under = new InventoryItem[n];
        int k = 0;
        for (int i = 0; i < count; i++) if (items[i].needsReorder()) under[k++] = items[i];
        return under;
    }

    /**
     * Restores (adds back) ingredients for a recipe.
     * Used to roll back reservations on failures.
     */
    public boolean restoreFor(brewery.recipes.Recipe recipe, int targetBottles) {
        if (recipe == null || recipe.yieldBottles() <= 0 || targetBottles <= 0) return false;
        double scale = ((double) targetBottles) / recipe.yieldBottles();
        java.util.List<brewery.recipes.RecipeRequirement> reqs = recipe.requirements();
        for (int i = 0; i < reqs.size(); i++) {
            brewery.recipes.RecipeRequirement r = reqs.get(i);
            InventoryItem it = findItem(r.ingredient());
            if (it == null) return false; // should not happen if previously reserved
        }
        // all items exist; proceed to add back
        for (int i = 0; i < reqs.size(); i++) {
            brewery.recipes.RecipeRequirement r = reqs.get(i);
            double need = r.amount() * scale;
            InventoryItem it = findItem(r.ingredient());
            it.add(need);
        }
        return true;
    }


    /** Returns all current inventory items as a fixed-size array copy. */
    public InventoryItem[] getAll() {
        InventoryItem[] snapshot = new InventoryItem[count];
        System.arraycopy(items, 0, snapshot, 0, count);
        return snapshot;
    }

    // -------------------------------------------------------------------------
    // Private helpers
    // -------------------------------------------------------------------------

    /** Finds an existing InventoryItem for a given ingredient (linear search). */
    private InventoryItem findItem(Ingredient ing) {
        for (int i = 0; i < count; i++) if (items[i].ingredient().equals(ing)) return items[i];
        return null;
    }

    /** Ensures that the internal array has space for at least one more item. */
    private void ensureCapacity() {
        if (count < items.length) return;
        InventoryItem[] newArr = new InventoryItem[items.length * 2];
        System.arraycopy(items, 0, newArr, 0, count);
        items = newArr;
    }
}

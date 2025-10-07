/**
 * -----------------------------------------------------------------------------
 * File Name: Inventory.java
 * Project: The Brewery Problem
 * Description:
 *     Maintains a mapping between ingredients and their current quantities
 *     in the brewery’s storage. This class provides basic inventory management
 *     operations such as adding new ingredients, checking availability, and
 *     consuming (taking) specific amounts for a batch.
 *
 *     The Inventory acts as a central data store for ingredient stock levels
 *     and supports integration with the brewing process when batches are
 *     created or updated.
 *
 * Author: Yue Wu
 * Course: CS5010 - Programming Design Paradigm
 * Date: October, 6, 2025
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */

package brewery.inventory;

import brewery.recipes.Ingredient;

import java.util.HashMap;
import java.util.Map;

/**
 * Inventory class that manages the stock of ingredients in the brewery.
 */
public class Inventory {
    // Map to hold ingredients and their corresponding inventory items
    private final Map<Ingredient, InventoryItem> items = new HashMap<>();

    /**
     * Adds a specified amount of an ingredient to the inventory.
     *
     * @param ing  The ingredient to add.
     * @param amt  The amount to add.
     * @param unit The unit of measurement for the amount.
     */
    public void add(Ingredient ing, double amt, String unit) {
        items.compute(ing, (k, v) -> {
            if (v == null) return new InventoryItem(ing, amt, unit);
            v.add(amt); return v;
        });
    }

    /**
     * Checks if the inventory has at least a specified amount of an ingredient.
     *
     * @param ing The ingredient to check.
     * @param amt The amount to check for.
     * @return True if the inventory has at least the specified amount, false otherwise.
     */
    public boolean has(Ingredient ing, double amt) {
        InventoryItem it = items.get(ing);
        return it != null && it.quantity() >= amt;
    }

    /**
     * Attempts to take a specified amount of an ingredient from the inventory.
     *
     * @param ing The ingredient to take.
     * @param amt The amount to take.
     * @return True if the amount was successfully taken, false otherwise.
     */
    public boolean take(Ingredient ing, double amt) {
        InventoryItem it = items.get(ing);
        return it != null && it.take(amt);
    }
}

/**
 * -----------------------------------------------------------------------------
 * File Name: InventoryItem.java
 * Project: The Brewery Problem
 * Description:
 *     Represents a single entry in the brewery’s inventory system, binding an
 *     {@link brewery.recipes.Ingredient} to its stored quantity and measurement
 *     unit. Provides methods for adjusting inventory levels by adding or taking
 *     specific amounts.
 *
 *     This class serves as the fundamental data unit managed by
 *     {@link brewery.inventory.Inventory}, encapsulating both the ingredient
 *     reference and its current quantity state.
 *
 * Author: Yue Wu
 * Course: CS5010 - Programming Design Paradigm
 * Date: October, 6, 2025
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */

package brewery.inventory;

import brewery.recipes.Ingredient;

/**
 * InventoryItem class that represents an ingredient and its quantity in the inventory.
 */
public class InventoryItem {
    private final Ingredient ingredient;
    private double quantity;
    private final String unit;

    /**
     * Constructs an InventoryItem with the specified ingredient, quantity, and unit.
     *
     * @param ingredient The ingredient.
     * @param quantity   The quantity of the ingredient.
     * @param unit       The unit of measurement for the quantity.
     */
    public InventoryItem(Ingredient ingredient, double quantity, String unit) {
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.unit = unit;
    }

    // Getters
    public Ingredient ingredient() {
        return ingredient;
    }
    // Returns the current quantity of the ingredient
    public double quantity() {
        return quantity;
    }
    // Returns the unit of measurement for the ingredient
    public String unit() {
        return unit;
    }

    // Methods to modify the quantity
    public void add(double delta) {
        quantity += delta;
    }
    // Attempts to take a specified amount from the inventory item
    public boolean take(double delta) {
        if (quantity >= delta) { quantity -= delta; return true; }
        return false;
    }
}

/**
 * -----------------------------------------------------------------------------
 * File Name: InventoryItem.java
 * Project: The Brewery Problem
 * Description:
 *     Represents a single entry in the brewery’s inventory system, binding an
 *     {@link brewery.recipes.Ingredient} to its stored quantity and measurement
 *     unit. Provides methods for adjusting inventory levels by adding or taking
 *     specific amounts, and supports a simple reorder-threshold mechanism.
 *
 * Author: Yue Wu
 * Course: CS5010 - Programming Design Paradigm
 * Date: October, 20, 2025
 * Version: 1.1
 * -----------------------------------------------------------------------------
 */
package brewery.inventory;

import brewery.recipes.Ingredient;

/** InventoryItem represents an ingredient and its quantity in the inventory. */
public class InventoryItem {
    private final Ingredient ingredient;
    private double quantity;
    private final String unit;
    private double reorderThreshold = 0.0;

    public InventoryItem(Ingredient ingredient, double quantity, String unit) {
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.unit = unit;
    }

    // --- Getters ---
    public Ingredient ingredient() { return ingredient; }
    public double quantity() { return quantity; }
    public String unit() { return unit; }
    public double threshold() { return reorderThreshold; }

    // --- Mutators ---
    public void add(double delta) { quantity += delta; }
    public boolean take(double delta) {
        if (quantity >= delta) { quantity -= delta; return true; }
        return false;
    }

    /** Sets the reorder threshold (clamped to >= 0). */
    public void setThreshold(double t) {
        reorderThreshold = (t < 0) ? 0.0 : t;
    }

    /** @return true if current quantity is at or below threshold. */
    public boolean needsReorder() {
        return quantity <= reorderThreshold;
    }
}

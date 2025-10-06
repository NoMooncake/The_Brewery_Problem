package brewery.inventory;

import brewery.recipes.Ingredient;

public class InventoryItem {
    private final Ingredient ingredient;
    private double quantity;
    private final String unit;

    public InventoryItem(Ingredient ingredient, double quantity, String unit) {
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.unit = unit;
    }

    public Ingredient ingredient() { return ingredient; }
    public double quantity() { return quantity; }
    public String unit() { return unit; }

    public void add(double delta) { quantity += delta; }
    public boolean take(double delta) {
        if (quantity >= delta) { quantity -= delta; return true; }
        return false;
    }
}

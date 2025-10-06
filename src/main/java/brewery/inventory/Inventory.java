package brewery.inventory;

import brewery.recipes.Ingredient;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<Ingredient, InventoryItem> items = new HashMap<>();

    public void add(Ingredient ing, double amt, String unit) {
        items.compute(ing, (k, v) -> {
            if (v == null) return new InventoryItem(ing, amt, unit);
            v.add(amt); return v;
        });
    }

    public boolean has(Ingredient ing, double amt) {
        InventoryItem it = items.get(ing);
        return it != null && it.quantity() >= amt;
    }

    public boolean take(Ingredient ing, double amt) {
        InventoryItem it = items.get(ing);
        return it != null && it.take(amt);
    }
}

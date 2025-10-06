package brewery.recipes;

import java.util.HashMap;
import java.util.Map;

public class RecipeLibrary {
    private final Map<String, Recipe> recipes = new HashMap<>();

    public void addRecipe(Recipe r) { recipes.put(r.name(), r); }
    public Recipe get(String name) {
        Recipe r = recipes.get(name);
        if (r == null) throw new IllegalArgumentException("Recipe not found: " + name);
        return r;
    }
}

package brewery.recipes;

public class RecipeRequirement {
    private final Ingredient ingredient;
    private final double amount;
    private final String unit;

    public RecipeRequirement(Ingredient ingredient, double amount, String unit) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.unit = unit;
    }

    public Ingredient ingredient() { return ingredient; }
    public double amount() { return amount; }
    public String unit() { return unit; }
}

package brewery.recipes;

import java.util.*;

public class Recipe {
    private final String name;
    private final double targetTempC;
    private final Map<String, Double> gravityTargets = new HashMap<>();
    private final List<RecipeRequirement> requirements = new ArrayList<>();

    public Recipe(String name, double targetTempC) {
        this.name = name;
        this.targetTempC = targetTempC;
    }

    public String name() { return name; }
    public double targetTempC() { return targetTempC; }
    public List<RecipeRequirement> requirements() { return Collections.unmodifiableList(requirements); }

    public void addRequirement(RecipeRequirement req) {
        requirements.add(req);
    }

    public Optional<RecipeRequirement> getRequirement(Ingredient ing) {
        return requirements.stream().filter(r -> r.ingredient().equals(ing)).findFirst();
    }
}

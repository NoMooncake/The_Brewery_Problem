package brewery.production;

import brewery.plant.Vat;
import brewery.recipes.Recipe;

import java.util.ArrayList;
import java.util.List;

public class Batch {
    private final String id;
    private final Recipe recipe;
    private final double volumeL;
    private Vat location;
    private BatchStatus status = BatchStatus.CREATED;
    private final List<Reading> readings = new ArrayList<>();

    public Batch(String id, Recipe recipe, double volumeL, Vat location) {
        this.id = id; this.recipe = recipe; this.volumeL = volumeL; this.location = location;
    }

    public String id() { return id; }
    public Recipe recipe() { return recipe; }
    public Vat location() { return location; }
    public BatchStatus status() { return status; }
    public List<Reading> readings() { return List.copyOf(readings); }

    public void moveTo(Vat v) { this.location = v; /* TODO: update status based on vat type */ }
    public void record(Reading r) { readings.add(r); }
}


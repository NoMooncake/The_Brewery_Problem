package brewery.app;

import brewery.inventory.Inventory;
import brewery.plant.PlantRegistry;
import brewery.production.Batch;
import brewery.recipes.Recipe;
import brewery.recipes.RecipeLibrary;
import brewery.services.MonitoringService;
import brewery.services.PathFinder;
import brewery.services.Scheduler;

import java.time.Instant;
import java.util.Objects;

public class BrewerySystem {
    private final Inventory inventory;
    private final RecipeLibrary recipes;
    private final PlantRegistry registry;
    private final PathFinder pathFinder;
    private final Scheduler scheduler;
    private final MonitoringService monitor;

    public BrewerySystem(Inventory inventory, RecipeLibrary recipes, PlantRegistry registry,
                         PathFinder pathFinder, Scheduler scheduler, MonitoringService monitor) {
        this.inventory = Objects.requireNonNull(inventory);
        this.recipes = Objects.requireNonNull(recipes);
        this.registry = Objects.requireNonNull(registry);
        this.pathFinder = Objects.requireNonNull(pathFinder);
        this.scheduler = Objects.requireNonNull(scheduler);
        this.monitor = Objects.requireNonNull(monitor);
    }

    public Batch createBatch(String recipeName, double sizeL, String mixingVatId) {
        Recipe r = recipes.get(recipeName);
        // TODO: check inventory, reserve/take ingredients
        // TODO: get mixing vat from registry
        // TODO: create Batch object and place in mixing vat
        throw new UnsupportedOperationException("createBatch not implemented");
    }

    public void scheduleTransfer(String batchId, String destVatId, Instant at) {
        // TODO: look up batch & vat, create TransferOrder, submit to scheduler
        throw new UnsupportedOperationException("scheduleTransfer not implemented");
    }

    public void bottle(String batchId) {
        // TODO: move to BottlingVat and run BottlingLine
        throw new UnsupportedOperationException("bottle not implemented");
    }
}

/**
 * -----------------------------------------------------------------------------
 * File Name: BrewerySystem.java
 * Project: The Brewery Problem
 * Description:
 *     Top-level façade/controller that coordinates the core subsystems of the
 *     brewery: Inventory, RecipeLibrary, PlantRegistry and the service layer
 *     (PathFinder, Scheduler, MonitoringService). It exposes a small API for
 *     typical operations:
 *       - createBatch(...)     : create a brewing batch from a recipe
 *       - scheduleTransfer(...): schedule liquid transfer between vats
 *       - bottle(...)          : trigger bottling for a finished batch
 *
 *     This class performs dependency injection via its constructor and keeps
 *     no static/global state, which makes it easy to test and to extend.
 *
 * Author: Yue Wu
 * Course: CS5010 - Programming Design Paradigm
 * Date: October, 6, 2025
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */

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

/**
 * Top-level façade/controller that coordinates the core subsystems of the brewery.
 * It exposes a small API for typical operations like creating batches, scheduling
 * transfers, and bottling.
 */
public class BrewerySystem {
    private final Inventory inventory;
    private final RecipeLibrary recipes;
    private final PlantRegistry registry;
    private final PathFinder pathFinder;
    private final Scheduler scheduler;
    private final MonitoringService monitor;

    /**
     * Constructs a BrewerySystem with the specified core components.
     *
     * @param inventory  the inventory system for managing ingredients and supplies
     * @param recipes    the recipe library containing brewing recipes
     * @param registry   the plant registry for managing vats and equipment
     * @param pathFinder the pathfinding service for optimizing transfers
     * @param scheduler  the scheduling service for managing tasks
     * @param monitor    the monitoring service for tracking system status
     * @throws NullPointerException if any of the parameters are null
     */
    public BrewerySystem(Inventory inventory, RecipeLibrary recipes, PlantRegistry registry,
                         PathFinder pathFinder, Scheduler scheduler, MonitoringService monitor) {
        this.inventory = Objects.requireNonNull(inventory);
        this.recipes = Objects.requireNonNull(recipes);
        this.registry = Objects.requireNonNull(registry);
        this.pathFinder = Objects.requireNonNull(pathFinder);
        this.scheduler = Objects.requireNonNull(scheduler);
        this.monitor = Objects.requireNonNull(monitor);
    }

    /**
     * Creates a new brewing batch based on the specified recipe.
     *
     * @param recipeName  the name of the recipe to use
     * @param sizeL       the size of the batch in liters
     * @param mixingVatId the ID of the mixing vat to use
     * @return the created Batch object
     * @throws UnsupportedOperationException if the method is not yet implemented
     */
    public Batch createBatch(String recipeName, double sizeL, String mixingVatId) {
        Recipe r = recipes.get(recipeName);
        // TODO: check inventory, reserve/take ingredients
        // TODO: get mixing vat from registry
        // TODO: create Batch object and place in mixing vat
        throw new UnsupportedOperationException("createBatch not implemented");
    }

    /**
     * Schedules a transfer of liquid from one vat to another at a specified time.
     *
     * @param batchId   the ID of the batch to transfer
     * @param destVatId the ID of the destination vat
     * @param at        the time to perform the transfer
     * @throws UnsupportedOperationException if the method is not yet implemented
     */
    public void scheduleTransfer(String batchId, String destVatId, Instant at) {
        // TODO: look up batch & vat, create TransferOrder, submit to scheduler
        throw new UnsupportedOperationException("scheduleTransfer not implemented");
    }

    /**
     * Triggers the bottling process for a finished batch.
     *
     * @param batchId the ID of the batch to bottle
     * @throws UnsupportedOperationException if the method is not yet implemented
     */
    public void bottle(String batchId) {
        // TODO: move to BottlingVat and run BottlingLine
        throw new UnsupportedOperationException("bottle not implemented");
    }
}

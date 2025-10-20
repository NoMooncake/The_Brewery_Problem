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
import brewery.plant.Vat;
import brewery.app.Console;

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
        Console.stage("Creating batch");
        Console.info("Using recipe: " + recipeName + ", size: " + sizeL + "L, vat: " + mixingVatId);

        // Placeholder implementation
        Recipe recipe = recipes.getByName(recipeName);
        // In a real implementation, we would check inventory, reserve ingredients, etc.
        Vat mixingVat = registry.get(mixingVatId);

        // Generate a unique batch ID
        String id = Batch.newId();

        // Create the batch
        Batch batch = new Batch(id, recipe, sizeL, mixingVat);

        Console.ok("Simulated batch creation successful (placeholder)");
        return batch;
    }


    /**
     * Creates a batch by target bottles using recipe + inventory check + clean vat allocation.
     * Returns null on any resource failure (no I/O here; Console 仍由占位调用处控制).
     */
    public Batch createBatchByBottles(String recipeName, int targetBottles) {
        Console.stage("Creating batch by bottles");
        Console.info("Recipe=" + recipeName + ", bottles=" + targetBottles);

        // lookup recipe
        Recipe recipe;
        try { recipe = recipes.getByName(recipeName); }
        catch (IllegalArgumentException | NullPointerException e) { Console.warn("Recipe not found"); return null; }

        // check & reserve inventory
        if (!inventory.hasFor(recipe, targetBottles)) {
            Console.warn("Insufficient ingredients for " + targetBottles + " bottles");
            return null;
        }
        boolean reserved = inventory.reserveFor(recipe, targetBottles);
        if (!reserved) { Console.warn("Reservation failed unexpectedly"); return null; }

        // allocate clean vat (with rollback if none available)
        brewery.plant.Vat mixingVat = registry.allocateCleanVat();
        if (mixingVat == null) {
            Console.warn("No clean vat available");
            // rollback reserved ingredients
            inventory.restoreFor(recipe, targetBottles);
            return null;
        }

        // create batch
        String id = Batch.newId();
        Batch batch = new Batch(id, recipe, /*volumeL=*/ targetBottles, mixingVat);

        // success
        Console.ok("Batch created: " + id + " @ vat " + mixingVat.id());
        return batch;
    }


    /**
     * Schedules a transfer of liquid from one vat to another at a specified time.
     *
     * @param batchId   the ID of the batch to transfer
     * @param destVatId the ID of the destination vat
     * @param at        the time to perform the transfer
     * @throws UnsupportedOperationException if the method is not yet implemented
     */
    /** Schedules a transfer between vats at a given time. */
    public void scheduleTransfer(String batchId, String destVatId, Instant at) {
        Console.stage("Scheduling transfer");
        Console.info("Scheduling transfer for batch " + batchId + " → " + destVatId + " @ " + at);

        Console.ok("Transfer scheduled (simulation mode)");
    }

    /**
     * Triggers the bottling process for a finished batch.
     *
     * @param batchId the ID of the batch to bottle
     * @throws UnsupportedOperationException if the method is not yet implemented
     */
    public void bottle(String batchId) {
        Console.stage("Bottling batch");
        Console.info("Batch " + batchId + " moved to bottling line");
        Console.ok("Bottling completed (simulation placeholder)");
    }

    /**
     * Bottles a concrete batch instance and marks its current vat DIRTY.
     * Keeps logic minimal: no repository or global state required.
     */
    public void bottle(Batch batch) {
        Console.stage("Bottling batch");
        if (batch == null) {
            Console.warn("Null batch reference; cannot bottle.");
            return;
        }

        String vatId = (batch.location() == null) ? "(none)" : batch.location().id();
        Console.info("Bottling batch " + batch.id() + " from vat " + vatId);

        // mark status as BOTTLED
        batch.markBottled();

        // mark current vat as DIRTY in registry
        if (batch.location() != null) {
            registry.markDirty(vatId);
            Console.info("Vat " + vatId + " marked DIRTY");
        }

        Console.ok("Bottled batch: " + batch.id());
    }

}

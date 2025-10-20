/**
 * -----------------------------------------------------------------------------
 * File Name: Main.java
 * Project: The Brewery Problem
 * Description:
 *     Entry point of the Brewery System application.
 *     <p>
 *     This class bootstraps the entire simulation by initializing all core
 *     subsystems: {@link brewery.inventory.Inventory}, {@link brewery.recipes.RecipeLibrary},
 *     {@link brewery.plant.PlantRegistry}, {@link brewery.services.PathFinder},
 *     {@link brewery.services.Scheduler}, and {@link brewery.services.MonitoringService}.
 *     <p>
 *     Once the system is assembled, it demonstrates the full brewing workflow
 *     through a staged sequence:
 *     <ol>
 *         <li><b>Stage A:</b> Add sample inventory ingredients</li>
 *         <li><b>Stage B:</b> Create base recipes</li>
 *         <li><b>Stage C:</b> Register plant vats and mark them CLEAN</li>
 *         <li><b>Stage D:</b> Create a brewing batch using bottle-based scaling</li>
 *         <li><b>Stage E:</b> (Optional) Bottle the finished product</li>
 *     </ol>
 *     Each stage outputs informative messages through {@link brewery.app.Console},
 *     ensuring that the control flow can be visually verified in the terminal.
 *
 * Design notes:
 * <ul>
 *   <li>No real-time I/O or user input—this is a simulated, deterministic run.</li>
 *   <li>All quantities and thresholds are illustrative only.</li>
 *   <li>Methods are kept short and cohesive to maintain low WMC.</li>
 * </ul>
 *
 * Author: Yue Wu
 * Course: CS5010 – Programming Design Paradigm
 * Date: October, 20, 2025
 * Version: 2.1
 * -----------------------------------------------------------------------------
 */
package brewery.app;

import brewery.inventory.Inventory;
import brewery.plant.PlantRegistry;
import brewery.recipes.*;
import brewery.services.MonitoringService;
import brewery.services.PathFinder;
import brewery.services.Scheduler;
import brewery.production.Batch;
import brewery.plant.Vat;

/**
 * The {@code Main} class serves as the single executable entry point for
 * the Brewery Problem simulation. It configures the system, populates
 * example data, and triggers one complete brewing run—from setup to shutdown.
 */
public class Main {

    /**
     * Prints a snapshot of all vats in the plant registry, showing their
     * IDs and cleanliness states.
     *
     * @param reg the plant registry containing vats
     */
    private static void printVatsSnapshot(brewery.plant.PlantRegistry reg) {
        brewery.plant.Vat[] vs = reg.all();
        for (int i = 0; i < vs.length; i++) {
            String state = vs[i].isClean() ? "CLEAN" : "DIRTY";
            Console.info("Vat " + vs[i].id() + " [" + state + "]");
        }
    }

    /**
     * Launches the Brewery System demonstration.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {


        // === Stage 0: Boot sequence ===
        Console.stage("BOOT SEQUENCE");
        Inventory inv = new Inventory();
        RecipeLibrary lib = new RecipeLibrary();
        PlantRegistry reg = new PlantRegistry();
        PathFinder path = new PathFinder();
        Scheduler sch = new Scheduler();
        MonitoringService mon = new MonitoringService();
        BrewerySystem system = new BrewerySystem(inv, lib, reg, path, sch, mon);
        Console.ok("Brewery booted successfully: " + system);

        // === Stage A: Add Inventory ===
        Console.stage("STAGE[A] Add Inventory");
        Ingredient WATER = new Ingredient("Water");
        Ingredient MALT  = new Ingredient("Malt");
        Ingredient HOPS  = new Ingredient("Hops");
        Ingredient YEAST = new Ingredient("Yeast");

        // Add sample quantities (units must match recipe definitions)
        inv.add(WATER, 100.0, "L");
        inv.add(MALT,   12.0, "kg");
        inv.add(HOPS,  1000.0, "g");
        inv.add(YEAST, 200.0, "g");

        // Optional: reorder thresholds
        inv.setThreshold(WATER, 50.0);
        inv.setThreshold(MALT,  4.0);
        Console.info("Sample ingredients added to Inventory.");

        mon.printReorderList(inv);

        // === Stage B: Create Recipes ===
        Console.stage("STAGE[B] Create Recipes");
        Recipe pale = new Recipe("Pale Ale", 18.0, 48); // 48 bottles per batch
        pale.addRequirement(new RecipeRequirement(WATER, 20.0, "L"));
        pale.addRequirement(new RecipeRequirement(MALT,   5.0, "kg"));
        pale.addRequirement(new RecipeRequirement(HOPS, 200.0, "g"));
        pale.addRequirement(new RecipeRequirement(YEAST, 50.0, "g"));
        lib.addRecipe(pale);
        Console.info("Recipe library populated with base recipes.");

        // === Stage C: Register Plant ===
        Console.stage("STAGE[C] Register Plant Equipment");
        reg.add(new MixingVat("M1", 500.0));
        Console.info("Plant vats registered and marked CLEAN.");
        printVatsSnapshot(reg);

        // === Stage D: Make Batch ===
        Console.stage("STAGE[D] Make Batch");
        Batch b = system.createBatchByBottles("Pale Ale", 48);
        if (b == null) {
            Console.warn("Batch creation failed.");
        } else {
            Console.ok("Batch creation initiated: " + b.id());
        }

        // === STAGE[E] Bottle Product ===
        Console.stage("STAGE[E] Bottle Product");
        if (b != null) {
            system.bottle(b);
        } else {
            Console.warn("No batch to bottle (previous stage failed).");
        }
        printVatsSnapshot(reg);
        mon.printReorderList(inv);


        // === End ===
        Console.stage("SYSTEM SHUTDOWN");
        Console.ok("Simulation completed successfully.");
    }

    static class MixingVat extends Vat {
        public MixingVat(String id, double capacityL) { super(id, capacityL); }
    }
}

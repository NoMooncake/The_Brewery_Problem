/**
 * -----------------------------------------------------------------------------
 * File Name: Main.java
 * Project: The Brewery Problem
 * Description:
 *     Entry point of the Brewery System application.
 *     This class initializes the core components of the system, including
 *     inventory, recipe library, plant registry, pathfinding, scheduling,
 *     and monitoring services. It then creates an instance of BrewerySystem,
 *     which coordinates the brewing workflow.
 *
 *     The main method serves as a bootstrap for the system, where additional
 *     demonstration logic can be implemented, such as registering vats,
 *     loading recipes, creating batches, scheduling transfers, and bottling.
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
import brewery.recipes.RecipeLibrary;
import brewery.services.MonitoringService;
import brewery.services.PathFinder;
import brewery.services.Scheduler;

/**
 * Main class to bootstrap the Brewery System application.
 * Initializes core components and creates an instance of BrewerySystem.
 */
public class Main {

    /**
     * Entry point of the application.
     * Initializes the BrewerySystem with its components and prints a startup message.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        BrewerySystem system = new BrewerySystem(
                new Inventory(),
                new RecipeLibrary(),
                new PlantRegistry(),
                new PathFinder(),
                new Scheduler(),
                new MonitoringService()
        );
        System.out.println("Brewery booted: " + system);
        // TODO: demo flow:
        //  1. Add sample recipes to the library
        //  2. Register vats in the plant
        //  3. Create and start a brewing batch
        //  4. Schedule liquid transfer between vats
        //  5. Bottle the finished product
    }
}

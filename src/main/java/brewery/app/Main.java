package brewery.app;

import brewery.inventory.Inventory;
import brewery.plant.PlantRegistry;
import brewery.recipes.RecipeLibrary;
import brewery.services.MonitoringService;
import brewery.services.PathFinder;
import brewery.services.Scheduler;

public class Main {
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
        // TODO: demo flow: add recipe, register vats, create batch, schedule transfer, bottle
    }
}

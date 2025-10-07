/**
 * -----------------------------------------------------------------------------
 * File Name: PlantRegistry.java
 * Project: The Brewery Problem
 * Description:
 *     Central registry that stores and manages all {@link Vat} instances
 *     within the brewery plant. Each vat is indexed by a unique identifier
 *     and can be retrieved or registered through this class.
 *
 *     The PlantRegistry provides a lookup service for other system components
 *     such as {@link brewery.app.BrewerySystem}, {@link brewery.services.PathFinder},
 *     and {@link brewery.production.TransferOrder}, allowing them to reference
 *     and coordinate vats during batch creation and transfer operations.
 *
 * Author: Yue Wu
 * Course: CS5010 - Programming Design Paradigm
 * Date: October, 6, 2025
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */

package brewery.plant;

import java.util.HashMap;
import java.util.Map;

// Registry for all vats in the plant
public class PlantRegistry {
    private final Map<String, Vat> vats = new HashMap<>();

    // Add a vat to the registry
    public void add(Vat v) {
        vats.put(v.id(), v);
    }
    // Retrieve a vat by its ID
    public Vat get(String id) {
        Vat v = vats.get(id);
        if (v == null) throw new IllegalArgumentException("Vat not found: " + id);
        return v;
    }
}


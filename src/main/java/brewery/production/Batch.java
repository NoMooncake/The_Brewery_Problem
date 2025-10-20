/**
 * -----------------------------------------------------------------------------
 * File Name: Batch.java
 * Project: The Brewery Problem
 * Description:
 *     Represents a single brewing batch as it progresses through various
 *     stages of production. Each batch is tied to a specific {@link Recipe},
 *     has a measurable volume, a current {@link Vat} location, and a list of
 *     recorded sensor readings (e.g., temperature and gravity).
 *
 *     The batch tracks its {@link BatchStatus} as it moves from mixing to
 *     fermentation, settling, and bottling. It serves as the core data unit
 *     for production scheduling, monitoring, and transfer operations.
 *
 * Author: Yue Wu
 * Course: CS5010 - Programming Design Paradigm
 * Date: October, 6, 2025
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */

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
    private static int SEQ = 1;
    public static String newId() {
        return "B" + (SEQ++);
    }

    // Constructor to initialize a batch with ID, recipe, volume, and initial vat location
    public Batch(String id, Recipe recipe, double volumeL, Vat location) {
        this.id = id; this.recipe = recipe; this.volumeL = volumeL; this.location = location;
    }

    // Getters for batch properties
    public String id() { return id; }
    public Recipe recipe() { return recipe; }
    public Vat location() { return location; }
    public BatchStatus status() { return status; }
    public List<Reading> readings() { return List.copyOf(readings); }

    // Methods to update batch status and location
    public void moveTo(Vat v) {
        this.location = v;
    }
    // mark the batch as started mixing
    public void startMixing() {
        this.status = BatchStatus.MIXING;
    }

    // mark the batch finished mixing
    public void markBottled() {
        this.status = BatchStatus.BOTTLED;
    }

    // Method to record a new sensor reading for the batch
    public void record(Reading r) {
        readings.add(r);
    }
}


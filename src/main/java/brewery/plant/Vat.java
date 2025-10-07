/**
 * -----------------------------------------------------------------------------
 * File Name: Vat.java
 * Project: The Brewery Problem
 * Description:
 *     Abstract base class representing a generic brewing vessel (vat) used
 *     throughout the production process. Each vat has a unique identifier,
 *     a fixed liquid capacity, and a cleanliness state that determines
 *     whether it can be safely used for the next batch operation.
 *
 *     Concrete subclasses such as {@link MixingVat}, {@link FermentingVat},
 *     {@link SettlingVat}, and {@link BottlingVat} define specific stages
 *     in the brewing workflow. The vat’s clean/dirty status is updated as
 *     batches are transferred, ensuring sanitary process control.
 *
 * Author: Yue Wu
 * Course: CS5010 - Programming Design Paradigm
 * Date: October, 6, 2025
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */

package brewery.plant;

public abstract class Vat {
    protected final String id;
    protected final double capacityL;
    protected boolean clean = true;

    protected Vat(String id, double capacityL) {
        this.id = id; this.capacityL = capacityL;
    }

    // Getters and state management methods
    public String id() {
        return id;
    }
    // Capacity in liters
    public double capacityL() {
        return capacityL;
    }
    // True if the vat is clean and ready for use
    public boolean isClean() {
        return clean;
    }
    // Mark the vat as clean
    public void markClean() {
        clean = true;
    }
    // Mark the vat as dirty
    public void markDirty() {
        clean = false;
    }
}

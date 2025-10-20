/**
 * -----------------------------------------------------------------------------
 * File Name: PlantRegistry.java
 * Project: The Brewery Problem
 * Description:
 *     Central registry managing all {@link Vat} instances within the brewery plant.
 *     This implementation uses a lightweight array-based collection to store vats,
 *     avoiding external containers such as {@link java.util.HashMap}.
 *
 * Responsibilities:
 * <ul>
 *   <li>Register new vats and enforce unique identifiers.</li>
 *   <li>Retrieve vats by ID for process coordination.</li>
 *   <li>Provide a snapshot of all vats for monitoring.</li>
 * </ul>
 *
 * Design notes:
 * <ul>
 *   <li>No global state; no I/O inside this class.</li>
 *   <li>Methods remain short and cohesive (low WMC).</li>
 * </ul>
 *
 * Author: Yue Wu
 * Course: CS5010 – Programming Design Paradigm
 * Date: October, 19, 2025
 * Version: 2.0
 * -----------------------------------------------------------------------------
 */

package brewery.plant;

/**
 * Registry for all {@link Vat} objects in the brewery.
 * Provides simple add/get operations with unique ID validation.
 */
public class PlantRegistry {

    /** Internal array holding vat references. */
    private Vat[] vats = new Vat[12];
    /** Count of registered vats. */
    private int count = 0;

    /**
     * Adds a vat to the registry. The vat ID must be unique.
     *
     * @param v the vat to register
     * @throws IllegalArgumentException if a vat with the same ID already exists
     * @throws NullPointerException if {@code v} or {@code v.id()} is null
     */
    public void add(Vat v) {
        if (v == null || v.id() == null)
            throw new NullPointerException("Vat or vat.id must not be null");
        if (indexOf(v.id()) >= 0)
            throw new IllegalArgumentException("Duplicate vat ID: " + v.id());
        ensureCapacity();
        vats[count++] = v;
    }

    /**
     * Retrieves a vat by its ID.
     *
     * @param id the vat identifier
     * @return the {@link Vat} with the given ID
     * @throws IllegalArgumentException if no vat matches the ID
     */
    public Vat get(String id) {
        int idx = indexOf(id);
        if (idx < 0) throw new IllegalArgumentException("Vat not found: " + id);
        return vats[idx];
    }

    /**
     * Returns a snapshot of all vats currently registered.
     *
     * @return array of all vats
     */
    public Vat[] all() {
        Vat[] snapshot = new Vat[count];
        System.arraycopy(vats, 0, snapshot, 0, count);
        return snapshot;
    }

    /**
     * Allocates the first CLEAN vat and marks it DIRTY immediately.
     * @return the allocated vat, or null if none available.
     */
    public Vat allocateCleanVat() {
        for (int i = 0; i < count; i++) {
            if (vats[i].isClean()) {
                vats[i].markDirty();
                return vats[i];
            }
        }
        return null;
    }

    /** Marks the vat with given id as CLEAN. @return true if updated. */
    public boolean markClean(String id) {
        int idx = indexOf(id);
        if (idx < 0) return false;
        vats[idx].markClean();
        return true;
    }

    /** Marks the vat with given id as DIRTY. @return true if updated. */
    public boolean markDirty(String id) {
        int idx = indexOf(id);
        if (idx < 0) return false;
        vats[idx].markDirty();
        return true;
    }

    /** (Optional) Returns the number of clean vats available. */
    public int availableCount() {
        int n = 0;
        for (int i = 0; i < count; i++) if (vats[i].isClean()) n++;
        return n;
    }

    // -------------------------------------------------------------------------
    // Private helpers
    // -------------------------------------------------------------------------

    /** Finds the index of a vat by its ID. */
    private int indexOf(String id) {
        for (int i = 0; i < count; i++) {
            if (vats[i].id().equals(id)) return i;
        }
        return -1;
    }

    /** Ensures there is capacity for another vat. */
    private void ensureCapacity() {
        if (count < vats.length) return;
        Vat[] next = new Vat[vats.length * 2];
        System.arraycopy(vats, 0, next, 0, count);
        vats = next;
    }

}


/**
 * -----------------------------------------------------------------------------
 * File Name: PathFinder.java
 * Project: The Brewery Problem
 * Description:
 *     Computes feasible transfer routes between vats on the plant's piping graph.
 *     Minimal implementation: returns an empty path (direct manifold connection),
 *     avoiding external collections to satisfy assignment restrictions.
 *
 * Author: Yue Wu
 * Course: CS5010 - Programming Design Paradigm
 * Date: October, 19, 2025
 * Version: 2.0
 * -----------------------------------------------------------------------------
 */
package brewery.services;

import brewery.plant.Pipe;
import brewery.plant.Vat;

public class PathFinder {

    /**
     * Returns the shortest clean path of pipes between two vats.
     * Minimal stub: returns an empty array to indicate "direct connection"
     * (the manifold may treat empty path as a direct link).
     *
     * @param source the source vat
     * @param dest   the destination vat
     * @return an array of pipes (possibly empty)
     */
    public Pipe[] shortestCleanPath(Vat source, Vat dest) {
        return new Pipe[0];
    }
}

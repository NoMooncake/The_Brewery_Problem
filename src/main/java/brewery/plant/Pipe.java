/**
 * -----------------------------------------------------------------------------
 * File Name: Pipe.java
 * Project: The Brewery Problem
 * Description:
 *     Represents a pipeline segment within the brewery’s manifold network.
 *     Each Pipe maintains a cleanliness state used to determine whether it
 *     can safely transport liquid between vats. The state can be toggled
 *     through {@code markClean()} and {@code markDirty()} depending on
 *     transfer usage and sanitation processes.
 *
 *     Pipes are coordinated by the {@link Manifold} class, which selects
 *     clean and available connections when establishing fluid routes for
 *     batch transfers.
 *
 * Author: Yue Wu
 * Course: CS5010 - Programming Design Paradigm
 * Date: October, 6, 2025
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */

package brewery.plant;
public class Pipe {
    private boolean clean = true;
    // True if the pipe is clean and ready for use
    public boolean isClean() {
        return clean;
    }
    // Mark the pipe as clean
    public void markClean() {
        clean = true;
    }
    // Mark the pipe as dirty
    public void markDirty() {
        clean = false;
    }
}


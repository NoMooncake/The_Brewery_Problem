/**
 * -----------------------------------------------------------------------------
 * File Name: Valve.java
 * Project: The Brewery Problem
 * Description:
 *     Represents a valve component in the brewery’s manifold system. A valve
 *     controls the opening and closing of fluid paths between connected pipes
 *     and vats. Its state determines whether liquid can pass through a given
 *     section of the system.
 *
 *     Valves are managed by the {@link Manifold}, which toggles them during
 *     batch transfer operations to route flow safely and prevent contamination
 *     between lines.
 *
 * Author: Yue Wu
 * Course: CS5010 - Programming Design Paradigm
 * Date: October, 6, 2025
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */

package brewery.plant;
public class Valve {
    private boolean open;
    // Open the valve
    public void open()  {
        open = true;
    }
    // Close the valve
    public void close() {
        open = false;
    }
    // Check if the valve is open
    public boolean isOpen() {
        return open;
    }
}

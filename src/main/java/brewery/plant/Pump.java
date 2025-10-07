/**
 * -----------------------------------------------------------------------------
 * File Name: Pump.java
 * Project: The Brewery Problem
 * Description:
 *     Represents a pump unit responsible for driving fluid through the
 *     brewery’s piping system. Each pump can be started or stopped, and
 *     maintains an internal running state used to determine whether it is
 *     actively operating during a transfer.
 *
 *     Pumps are managed collectively by the {@link Manifold}, which activates
 *     them when establishing flow between vats as part of a transfer process.
 *
 * Author: Yue Wu
 * Course: CS5010 - Programming Design Paradigm
 * Date: October, 6, 2025
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */

package brewery.plant;
public class Pump {
    private boolean running;
    // Start the pump
    public void start() {
        running = true;
    }
    // Stop the pump
    public void stop()  {
        running = false;
    }
    // Check if the pump is running
    public boolean isRunning() {
        return running;
    }
}


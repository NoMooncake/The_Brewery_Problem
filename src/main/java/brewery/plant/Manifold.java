/**
 * -----------------------------------------------------------------------------
 * File Name: Manifold.java
 * Project: The Brewery Problem
 * Description:
 *     Models the plant’s connection hub that coordinates pipes, valves, and
 *     pumps to establish fluid routes between vats. The manifold maintains
 *     internal arrays of {@link Pipe}, {@link Valve}, and {@link Pump},
 *     avoiding external collection classes in compliance with project rules.
 *
 *     It exposes a high-level API {@link #connect(Vat, Vat, Pipe[])} to
 *     establish a route and {@link #transfer(brewery.production.Batch, Vat, Vat)}
 *     to simulate the transfer process. In the current minimal implementation,
 *     these methods only validate arguments and perform simple state updates.
 *
 * Author: Yue Wu
 * Course: CS5010 - Programming Design Paradigm
 * Date: October, 19, 2025
 * Version: 2.0
 * -----------------------------------------------------------------------------
 */

package brewery.plant;

import brewery.production.Batch;

/**
 * Simplified manifold class managing connections between vats.
 * <p>
 * In this minimal version, all operations are stubbed—no physical
 * valve or pump actuation occurs. This design allows the rest of
 * the system (e.g., {@link brewery.production.TransferOrder}) to
 * execute successfully and demonstrate orchestration flow.
 */
public class Manifold {

    /** Internal arrays for pipes, valves, and pumps (no external lists). */
    private Pipe[] pipes = new Pipe[16];
    private Valve[] valves = new Valve[8];
    private Pump[] pumps = new Pump[8];
    private int pipeCount = 0, valveCount = 0, pumpCount = 0;

    /**
     * Registers a new pipe in the manifold.
     *
     * @param p the pipe to register
     */
    public void registerPipe(Pipe p) {
        ensurePipeCapacity();
        pipes[pipeCount++] = p;
    }

    /**
     * Connects a source vat to a destination vat using a provided path.
     * <p>
     * In this simplified version, the method performs basic validation only.
     *
     * @param source the source vat
     * @param dest   the destination vat
     * @param path   array of pipes composing the route
     */
    public void connect(Vat source, Vat dest, Pipe[] path) {
        if (source == null || dest == null) {
            throw new IllegalArgumentException("Source and destination vats cannot be null.");
        }
        // Future: open valves, activate pumps, mark pipes as in use, etc.
        // Currently acts as a placeholder for orchestration.
    }

    /**
     * Simulates transferring a batch from one vat to another.
     *
     * @param batch  the batch being transferred
     * @param source the source vat
     * @param dest   the destination vat
     */
    public void transfer(Batch batch, Vat source, Vat dest) {
        if (batch == null || source == null || dest == null)
            throw new IllegalArgumentException("Invalid transfer parameters.");
        // Future: update flow states, mark pipes dirty, adjust volumes, etc.
    }

    /**
     * Returns a snapshot array of all registered pipes.
     *
     * @return array of {@link Pipe}
     */
    public Pipe[] pipes() {
        Pipe[] snapshot = new Pipe[pipeCount];
        System.arraycopy(pipes, 0, snapshot, 0, pipeCount);
        return snapshot;
    }

    // -------------------------------------------------------------------------
    // Private helper
    // -------------------------------------------------------------------------

    /** Ensures pipe array capacity. */
    private void ensurePipeCapacity() {
        if (pipeCount < pipes.length) return;
        Pipe[] newArr = new Pipe[pipes.length * 2];
        System.arraycopy(pipes, 0, newArr, 0, pipeCount);
        pipes = newArr;
    }
}

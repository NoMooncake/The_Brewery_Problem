/**
 * -----------------------------------------------------------------------------
 * File Name: Manifold.java
 * Project: The Brewery Problem
 * Description:
 *     Models the plant’s connection hub that coordinates pipes, valves, and
 *     pumps to establish fluid routes between vats. The manifold maintains
 *     internal collections of {@link Pipe}, {@link Valve}, and {@link Pump},
 *     and exposes a high-level API (connect) to assemble an operational path
 *     from a source {@link Vat} to a destination {@link Vat}.
 *
 *     In the full system, this component is typically invoked by transfer
 *     orchestration (e.g., a TransferOrder) after a path is computed by
 *     {@link brewery.services.PathFinder}. It is responsible for selecting
 *     clean/available segments and preparing actuation (open/close valves,
 *     start/stop pumps) required for a safe transfer.
 *
 * Author: Yue Wu
 * Course: CS5010 - Programming Design Paradigm
 * Date: October, 6, 2025
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */

package brewery.plant;

import java.util.ArrayList;
import java.util.List;

// Manages the collection of pipes, valves, and pumps to connect vats
public class Manifold {
    private final List<Pipe> pipes = new ArrayList<>();
    private final List<Valve> valves = new ArrayList<>();
    private final List<Pump> pumps = new ArrayList<>();

    // Accessors for the internal collections
    public List<Pipe> pipes() {
        return pipes;
    }
    public List<Valve> valves() {
        return valves;
    }
    public List<Pump> pumps() {
        return pumps;
    }

    // Connects source vat to destination vat by selecting and preparing the necessary pipes, valves, and pumps
    public List<Pipe> connect(Vat source, Vat dest) {
        // TODO: choose clean pipes/valves, operate pumps/valves
        return List.of();
    }
}


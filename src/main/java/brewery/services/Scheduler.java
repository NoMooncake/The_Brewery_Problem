/**
 * -----------------------------------------------------------------------------
 * File Name: Scheduler.java
 * Project: The Brewery Problem
 * Description:
 *     Handles time-based orchestration of {@link brewery.production.TransferOrder}
 *     execution within the brewery system. This implementation replaces
 *     {@link java.util.LinkedList} with a simple array-backed structure to
 *     comply with assignment restrictions.
 *
 *     Responsibilities:
 *     <ul>
 *       <li>Store scheduled {@link TransferOrder} objects with execution time.</li>
 *       <li>Execute orders whose scheduled time has arrived via {@link #tick(Instant)}.</li>
 *       <li>Provide visibility into pending tasks for monitoring.</li>
 *     </ul>
 *
 * Design notes:
 * <ul>
 *   <li>No external data structures; all storage is manual and linear.</li>
 *   <li>Each method performs a single clear action to maintain low WMC.</li>
 *   <li>No I/O or printing—output handled by higher-level services.</li>
 * </ul>
 *
 * Author: Yue Wu
 * Course: CS5010 – Programming Design Paradigm
 * Date: October, 19, 2025
 * Version: 2.0
 * -----------------------------------------------------------------------------
 */

package brewery.services;

import brewery.production.TransferOrder;
import brewery.plant.Manifold;
import brewery.plant.PlantRegistry;
import brewery.services.PathFinder;

import java.time.Instant;

/**
 * Lightweight scheduler managing timed {@link TransferOrder} executions.
 */
public class Scheduler {

    /** Internal record storing a transfer order and its scheduled execution time. */
    private static class Scheduled {
        final TransferOrder order;
        final Instant when;
        Scheduled(TransferOrder order, Instant when) {
            this.order = order; this.when = when;
        }
    }

    /** Array-backed queue of scheduled orders. */
    private Scheduled[] queue = new Scheduled[8];
    /** Current number of valid elements. */
    private int count = 0;

    /**
     * Adds a new transfer order to the schedule.
     *
     * @param order the order to schedule
     * @param when  the time at which the order should execute
     * @throws NullPointerException if any argument is null
     */
    public void schedule(TransferOrder order, Instant when) {
        if (order == null || when == null)
            throw new NullPointerException("Order and time cannot be null");
        ensureCapacity();
        queue[count++] = new Scheduled(order, when);
    }

    /**
     * Executes all due orders up to the given time.
     * <p>In this simplified version, execution is simulated by
     * invoking {@code order.execute()} if defined, or marking as done.</p>
     *
     * @param now the current time used to check for due orders
     */
    public void tick(Instant now, PathFinder pathFinder, Manifold manifold, PlantRegistry registry) {
        int i = 0;
        while (i < count) {
            Scheduled s = queue[i];
            if (!now.isBefore(s.when)) {
                s.order.execute(pathFinder, manifold, registry);
                removeAt(i);
            } else {
                i++;
            }
        }
    }

    /**
     * Returns the number of pending (not yet executed) orders.
     *
     * @return the number of scheduled tasks remaining
     */
    public int pendingCount() { return count; }

    // -------------------------------------------------------------------------
    // Private helpers
    // -------------------------------------------------------------------------

    /** Ensures internal array has room for at least one more entry. */
    private void ensureCapacity() {
        if (count < queue.length) return;
        Scheduled[] next = new Scheduled[queue.length * 2];
        System.arraycopy(queue, 0, next, 0, count);
        queue = next;
    }

    /** Removes the entry at the given index by shifting subsequent elements. */
    private void removeAt(int idx) {
        for (int j = idx; j < count - 1; j++) queue[j] = queue[j + 1];
        queue[--count] = null;
    }
}
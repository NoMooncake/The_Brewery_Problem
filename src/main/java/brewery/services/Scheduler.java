/**
 * -----------------------------------------------------------------------------
 * File Name: Scheduler.java
 * Project: The Brewery Problem
 * Description:
 *     Handles time-based orchestration of {@link brewery.production.TransferOrder}
 *     execution within the brewery system. The Scheduler maintains a queue of
 *     pending transfer tasks, each paired with a scheduled execution time, and
 *     processes them when their designated time arrives.
 *
 *     In a complete implementation, {@code tick(Instant now)} would regularly
 *     evaluate queued orders, execute those whose time has elapsed, and delegate
 *     their operations to the relevant plant components and services.
 *
 * Author: Yue Wu
 * Course: CS5010 - Programming Design Paradigm
 * Date: October, 6, 2025
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */

package brewery.services;

import brewery.production.TransferOrder;

import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;

public class Scheduler {
    private final Queue<Scheduled> queue = new LinkedList<>();

    // Schedule a transfer order to execute at a specific time
    public void schedule(TransferOrder order, Instant when) {
        queue.add(new Scheduled(order, when));
    }

    // Process due orders as of the given time
    public void tick(Instant now) {
        // TODO: pop due orders and execute
    }

    // Internal record to pair a transfer order with its scheduled time
    private record Scheduled(TransferOrder order, Instant when) {

    }
}

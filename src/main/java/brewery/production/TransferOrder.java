/**
 * -----------------------------------------------------------------------------
 * File Name: TransferOrder.java
 * Project: The Brewery Problem
 * Description:
 *     Encapsulates an instruction to move a {@link Batch} from one {@link Vat}
 *     to another at a scheduled time. A TransferOrder coordinates with
 *     {@link brewery.services.PathFinder} to compute a clean/feasible route,
 *     and with {@link brewery.plant.Manifold} to actuate pipes, valves, and
 *     pumps for the physical transfer. It may consult the
 *     {@link brewery.plant.PlantRegistry} to resolve equipment references.
 *
 *     In a full implementation, execution should update plant sanitation
 *     state (clean/dirty) and the batch’s location/status accordingly.
 *
 * Author: Yue Wu
 * Course: CS5010 - Programming Design Paradigm
 * Date: October, 6, 2025
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */

package brewery.production;

import brewery.plant.Manifold;
import brewery.plant.PlantRegistry;
import brewery.plant.Vat;
import brewery.services.PathFinder;

import java.time.Instant;

public class TransferOrder {
    private final Batch batch;
    private final Vat from;
    private final Vat to;
    private final Instant at;

    // Constructor to initialize a transfer order with batch, source vat, destination vat, and scheduled time
    public TransferOrder(Batch batch, Vat from, Vat to, Instant at) {
        this.batch = batch; this.from = from; this.to = to; this.at = at;
    }

    // Getters for transfer order properties
    public void execute(PathFinder pathFinder, Manifold manifold, PlantRegistry registry) {
        if (batch == null || from == null || to == null) {
            throw new IllegalStateException("TransferOrder is incomplete (batch/from/to)");
        }

        // Compute the clean path using PathFinder
        var path = pathFinder.shortestCleanPath(from, to);

        // Connect the vats via the manifold and perform the transfer
        manifold.connect(from, to, path);
        manifold.transfer(batch, from, to);

        // Update the batch's location and mark vats as dirty
        from.markDirty();
        batch.moveTo(to);
    }
}
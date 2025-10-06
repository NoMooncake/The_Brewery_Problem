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

    public TransferOrder(Batch batch, Vat from, Vat to, Instant at) {
        this.batch = batch; this.from = from; this.to = to; this.at = at;
    }

    public void execute(PathFinder pathFinder, Manifold manifold, PlantRegistry registry) {
        // TODO:
        // 1) compute path: pathFinder.shortestCleanPath(from, to)
        // 2) manifold.connect(from, to)
        // 3) mark vats/pipes dirty/clean as needed; update batch.moveTo(to)
        throw new UnsupportedOperationException("execute not implemented");
    }
}


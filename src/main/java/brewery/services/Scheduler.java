package brewery.services;

import brewery.production.TransferOrder;

import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;

public class Scheduler {
    private final Queue<Scheduled> queue = new LinkedList<>();

    public void schedule(TransferOrder order, Instant when) {
        queue.add(new Scheduled(order, when));
    }

    public void tick(Instant now) {
        // TODO: pop due orders and execute
    }

    private record Scheduled(TransferOrder order, Instant when) { }
}

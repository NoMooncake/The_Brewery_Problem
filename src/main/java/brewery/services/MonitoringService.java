package brewery.services;

import brewery.production.Batch;
import brewery.production.Reading;

import java.time.Instant;

public class MonitoringService {
    public void checkTemperature(Batch b, Thermometer t, brewery.recipes.Recipe r) {
        double temp = t.read();
        b.record(new Reading(Instant.now(), temp, null));
        // TODO: compare with r.targetTempC()
    }

    public void recordGravity(Batch b, Hydrometer h, double value) {
        b.record(new Reading(Instant.now(), null, value));
    }
}


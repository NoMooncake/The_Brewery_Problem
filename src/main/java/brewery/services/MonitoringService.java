/**
 * -----------------------------------------------------------------------------
 * File Name: MonitoringService.java
 * Project: The Brewery Problem
 * Description:
 *     Provides monitoring and data recording functionality for active
 *     {@link brewery.production.Batch} instances. The service collects sensor
 *     readings such as temperature and specific gravity from instruments like
 *     {@link Thermometer} and {@link Hydrometer}, and stores them as
 *     {@link brewery.production.Reading} objects within each batch.
 *
 *     This component acts as an intermediary between physical sensors and the
 *     Brewery System, supporting process tracking and quality assurance. In a
 *     future implementation, it could generate alerts or trigger adjustments
 *     when readings deviate from recipe targets.
 *
 * Author: Yue Wu
 * Course: CS5010 - Programming Design Paradigm
 * Date: October， 6, 2025
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */

package brewery.services;

import brewery.production.Batch;
import brewery.production.Reading;

import java.time.Instant;

public class MonitoringService {
    // Record temperature reading from the thermometer into the batch
    public void checkTemperature(Batch b, Thermometer t, brewery.recipes.Recipe r) {
        double temp = t.read();
        b.record(new Reading(Instant.now(), temp, null));
        // TODO: compare with r.targetTempC()
    }

    // Record specific gravity reading from the hydrometer into the batch
    public void recordGravity(Batch b, Hydrometer h, double value) {
        b.record(new Reading(Instant.now(), null, value));
    }
}


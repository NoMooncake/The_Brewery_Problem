/**
 * -----------------------------------------------------------------------------
 * File Name: Reading.java
 * Project: The Brewery Problem
 * Description:
 *     Represents a single monitoring data point collected from a batch during
 *     production. Each Reading captures the time of measurement along with
 *     the temperature (in Celsius) and specific gravity values recorded at
 *     that moment.
 *
 *     Readings are typically produced by sensors such as thermometers and
 *     hydrometers under the control of the {@link brewery.services.MonitoringService},
 *     and are stored within a {@link Batch} for process tracking and quality
 *     assurance.
 *
 * Author: Yue Wu
 * Course: CS5010 - Programming Design Paradigm
 * Date: October, 6, 2025
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */

package brewery.production;

import java.time.Instant;

public class Reading {
    private final Instant when;
    private final Double tempC;
    private final Double gravity;

    // Constructor to initialize a reading with timestamp, temperature, and gravity
    public Reading(Instant when, Double tempC, Double gravity) {
        this.when = when; this.tempC = tempC; this.gravity = gravity;
    }

    // Getters for reading properties
    public Instant when() {
        return when;
    }
    // Temperature in Celsius
    public Double tempC() {
        return tempC;
    }
    // Specific gravity
    public Double gravity() {
        return gravity;
    }
}


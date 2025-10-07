/**
 * -----------------------------------------------------------------------------
 * File Name: Sensor.java
 * Project: The Brewery Problem
 * Description:
 *     Abstract base class for all sensor types used within the brewery’s
 *     monitoring subsystem. Each concrete subclass (e.g.,
 *     {@link Thermometer}, {@link Hydrometer}) must implement the
 *     {@link #read()} method to provide measurement data such as temperature
 *     or specific gravity.
 *
 *     This abstraction enables the {@link MonitoringService} to record sensor
 *     readings uniformly without depending on specific hardware details,
 *     promoting modularity and testability.
 *
 * Author: Yue Wu
 * Course: CS5010 - Programming Design Paradigm
 * Date: October, 6, 2025
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */

package brewery.services;

public abstract class Sensor {
    public abstract double read();
}


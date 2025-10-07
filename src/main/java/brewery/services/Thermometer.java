/**
 * -----------------------------------------------------------------------------
 * File Name: Thermometer.java
 * Project: The Brewery Problem
 * Description:
 *     Concrete implementation of {@link Sensor} representing a thermometer
 *     used to measure the temperature of a brewing batch. This class provides
 *     temperature readings (in Celsius) that are recorded by the
 *     {@link MonitoringService} for process control and quality tracking.
 *
 *     In this simplified version, {@link #read()} returns a mock value.
 *     In a complete system, it would interface with actual temperature
 *     sensing hardware or simulation data sources.
 *
 * Author: Yue Wu
 * Course: CS5010 - Programming Design Paradigm
 * Date: October, 6, 2025
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */

package brewery.services;
public class Thermometer extends Sensor {
    @Override public double read() {
        return 0.0; /* TODO: mock reading */
    }
}


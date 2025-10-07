/**
 * -----------------------------------------------------------------------------
 * File Name: Hydrometer.java
 * Project: The Brewery Problem
 * Description:
 *     Concrete implementation of {@link Sensor} that simulates a hydrometer,
 *     used to measure the specific gravity of the brew during fermentation
 *     and settling phases. The reading reflects the sugar concentration,
 *     which correlates with alcohol content as fermentation progresses.
 *
 *     In a complete system, this class would interface with actual sensor
 *     hardware or a data acquisition module to obtain live readings.
 *
 * Author: Yue Wu
 * Course: CS5010 - Programming Design Paradigm
 * Date: October, 6, 2025
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */

package brewery.services;
public class Hydrometer extends Sensor {
    @Override public double read() {
        return 1.000; /* TODO: mock reading */
    }
}

/**
 * -----------------------------------------------------------------------------
 * File Name: BottlingVat.java
 * Project: The Brewery Problem
 * Description:
 *     Specialized type of {@link Vat} used for the final stage of production,
 *     where the finished brew is transferred for bottling. This vat represents
 *     the endpoint of the brewing pipeline before packaging occurs.
 *
 *     Instances of this class are typically managed by {@link brewery.plant.PlantRegistry}
 *     and are accessed when the {@code BrewerySystem.bottle(...)} operation is executed.
 *
 * Author: Yue Wu
 * Course: CS5010 - Programming Design Paradigm
 * Date: October, 6, 2025
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */

package brewery.plant;
public class BottlingVat extends Vat {
    public BottlingVat(String id, double cap){
        super(id, cap);
    }
}

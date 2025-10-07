/**
 * -----------------------------------------------------------------------------
 * File Name: FermentingVat.java
 * Project: The Brewery Problem
 * Description:
 *     Represents a fermentation vessel within the brewery, extending the
 *     abstract {@link Vat} class. It is responsible for holding batches
 *     during the fermentation phase, where yeast converts sugars into alcohol.
 *
 *     This vat type is registered in the {@link brewery.plant.PlantRegistry}
 *     and used by the Brewery System during the mid-stage of the brewing
 *     process before settling or bottling.
 *
 * Author: Yue Wu
 * Course: CS5010 - Programming Design Paradigm
 * Date: October, 6, 2025
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */

package brewery.plant;
public class FermentingVat extends Vat {
    public FermentingVat(String id, double cap){
        super(id, cap);
    }
}

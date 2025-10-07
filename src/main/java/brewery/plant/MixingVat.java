/**
 * -----------------------------------------------------------------------------
 * File Name: MixingVat.java
 * Project: The Brewery Problem
 * Description:
 *     Represents the initial processing vessel in the brewing pipeline,
 *     extending the abstract {@link Vat} class. A MixingVat is used to
 *     combine raw ingredients and prepare the wort before fermentation.
 *
 *     This vat marks the starting point for most batches and interacts
 *     closely with the {@link brewery.inventory.Inventory} during batch
 *     creation. It is registered and managed within the
 *     {@link brewery.plant.PlantRegistry}.
 *
 * Author: Yue Wu
 * Course: CS5010 - Programming Design Paradigm
 * Date: October, 6, 2025
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */

package brewery.plant;
public class MixingVat extends Vat {
    public MixingVat(String id, double cap){
        super(id, cap);
    }
}


/**
 * -----------------------------------------------------------------------------
 * File Name: SettlingVat.java
 * Project: The Brewery Problem
 * Description:
 *     Specialized subclass of {@link Vat} used during the clarification or
 *     sedimentation phase of the brewing process. The SettlingVat allows
 *     particles and yeast to settle before the brew is transferred to the
 *     bottling stage.
 *
 *     Typically, this vat follows the {@link FermentingVat} in the production
 *     workflow and precedes the {@link BottlingVat}. It is registered and
 *     tracked in the {@link brewery.plant.PlantRegistry} for transfer
 *     coordination.
 *
 * Author: Yue Wu
 * Course: CS5010 - Programming Design Paradigm
 * Date: October, 6, 2025
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */

package brewery.plant;
public class SettlingVat extends Vat {
    // Constructor to initialize the settling vat with an ID and capacity
    public SettlingVat(String id, double cap){
        super(id, cap);
    }
}


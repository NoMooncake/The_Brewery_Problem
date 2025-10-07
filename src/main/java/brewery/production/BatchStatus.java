/**
 * -----------------------------------------------------------------------------
 * File Name: BatchStatus.java
 * Project: The Brewery Problem
 * Description:
 *     Enumeration representing the sequential states a brewing batch passes
 *     through during the production process. Each status corresponds to a
 *     specific stage in the brewery workflow, from initial creation to
 *     completion.
 *
 *     The typical lifecycle is:
 *         CREATED → MIXING → FERMENTING → SETTLING → BOTTLING → BOTTLED
 *
 *     This enum is used by {@link Batch} and related classes to track
 *     operational progress and coordinate scheduling or monitoring actions.
 *
 * Author: Yue Wu
 * Course: CS5010 - Programming Design Paradigm
 * Date: October, 6, 2025
 * Version: 1.0
 * -----------------------------------------------------------------------------
 */

package brewery.production;
public enum BatchStatus { CREATED, MIXING, FERMENTING, SETTLING, BOTTLING, BOTTLED }


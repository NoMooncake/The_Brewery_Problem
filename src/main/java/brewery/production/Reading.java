package brewery.production;

import java.time.Instant;

public class Reading {
    private final Instant when;
    private final Double tempC;
    private final Double gravity;

    public Reading(Instant when, Double tempC, Double gravity) {
        this.when = when; this.tempC = tempC; this.gravity = gravity;
    }

    public Instant when() { return when; }
    public Double tempC() { return tempC; }
    public Double gravity() { return gravity; }
}


package brewery.plant;

import java.util.HashMap;
import java.util.Map;

public class PlantRegistry {
    private final Map<String, Vat> vats = new HashMap<>();

    public void add(Vat v) { vats.put(v.id(), v); }
    public Vat get(String id) {
        Vat v = vats.get(id);
        if (v == null) throw new IllegalArgumentException("Vat not found: " + id);
        return v;
    }
}


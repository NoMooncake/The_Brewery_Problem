package brewery.plant;

import java.util.ArrayList;
import java.util.List;

public class Manifold {
    private final List<Pipe> pipes = new ArrayList<>();
    private final List<Valve> valves = new ArrayList<>();
    private final List<Pump> pumps = new ArrayList<>();

    public List<Pipe> pipes() { return pipes; }
    public List<Valve> valves() { return valves; }
    public List<Pump> pumps() { return pumps; }

    public List<Pipe> connect(Vat source, Vat dest) {
        // TODO: choose clean pipes/valves, operate pumps/valves
        return List.of();
    }
}


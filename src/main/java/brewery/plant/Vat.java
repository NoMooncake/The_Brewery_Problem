package brewery.plant;

public abstract class Vat {
    protected final String id;
    protected final double capacityL;
    protected boolean clean = true;

    protected Vat(String id, double capacityL) {
        this.id = id; this.capacityL = capacityL;
    }

    public String id() { return id; }
    public double capacityL() { return capacityL; }
    public boolean isClean() { return clean; }
    public void markClean() { clean = true; }
    public void markDirty() { clean = false; }
}

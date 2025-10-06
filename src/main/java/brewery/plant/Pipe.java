package brewery.plant;
public class Pipe {
    private boolean clean = true;
    public boolean isClean() { return clean; }
    public void markClean() { clean = true; }
    public void markDirty() { clean = false; }
}


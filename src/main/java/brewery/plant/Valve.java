package brewery.plant;
public class Valve {
    private boolean open;
    public void open()  { open = true; }
    public void close() { open = false; }
    public boolean isOpen() { return open; }
}

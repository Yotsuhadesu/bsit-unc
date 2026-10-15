package program;
public class Coop {
    private String location;
    private int capacity;
    private int currentOccupancy;

    public Coop(String location, int capacity) {
        this.location = location;
        if (capacity > 0) {
            this.capacity = capacity;
        } else {
            throw new IllegalArgumentException("Invalid capacity.");
        }
    }

    public void addOccupant () throws FullCoopException {
        if (currentOccupancy < capacity) {
            this.currentOccupancy++;
        } else {
           throw new FullCoopException();
        }
    }

    public String getLocation() { return this.location; }
}

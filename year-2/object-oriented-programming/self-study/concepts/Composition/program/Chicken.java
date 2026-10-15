package program;
public class Chicken {
    private String name;
    private Coop coop;
    
    public Chicken(String name, Coop coop) throws FullCoopException {
        this.name = name;
        this.coop = coop;
        coop.addOccupant();
    }

    public String getName() { return this.name; }
    public String getCoopLocation() { return this.coop.getLocation(); }
}

package program;
import java.util.ArrayList;

public class Farm {
    ArrayList<Chicken> chickens = new ArrayList<>();

    public void addChicken(String name, Coop coop) { 
        try {
            Chicken chicken = new Chicken(name, coop);  
            this.chickens.add(chicken);
        } catch (FullCoopException e) {
            System.out.println(name + " cannot be added to the coop.");
        }
    }

    public void printAllChickens() {
        System.out.println("--- Chicken List ---");
        System.out.println("=".repeat(25));
        for(Chicken chicken : this.chickens) {
            System.out.println("Name: " + chicken.getName());
            System.out.println("Coop Location: " + chicken.getCoopLocation());
            System.out.println("-".repeat(25));
        }
    }
}

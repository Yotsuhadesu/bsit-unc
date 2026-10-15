/*
    Elano, Jethro
    De Los Santos, Rhay Airon
    Antonio, Abegail
    Zaragoza, Ian Matthew
 */
import java.util.*;

public class GroceryList {
    public static void main(String[] args) {
        // create LinkedList of Strings
        LinkedList<String> ing = new LinkedList<>();    // LinkedList object
        Scanner sc = new Scanner(System.in);    // Scanner object

        // add 5 items
        for (int i = 1; i <= 5; i++) {
            System.out.print("Item " + i + ": ");
            ing.add(sc.nextLine()); // puts in the LinkedList
        }

        // check sugar
        String target = "Sugar";

        if (ing.contains(target)) {
            int index = ing.indexOf(target);
            ing.set(index, "Stevia");
        } else {
            ing.offer("Stevia");
        }

        System.out.println(ing);

        sc.close();
    }
}

/*
    Elano, Jethro
    De Los Santos, Rhay Airon
    Antonio, Abegail
    Zaragoza, Ian Matthew
 */
import java.util.*;

public class SearchList {
    // create LinkedList of Strings
    static LinkedList<String> names = new LinkedList<>();    // LinkedList object
    static Scanner sc = new Scanner(System.in);    // Scanner object
    static String tar;

    public static void iPO (int n) {
        // takes a list of names
        for (int i = 0; i < n; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            // store to LinkedList
            names.add(sc.nextLine());
        }

        // set target
        System.out.print("Target: ");
        tar = sc.nextLine();
    }

    public static void main(String[] args) {
        // ask how many times the loop will rum
        System.out.print("Number of names: ");
        int n = sc.nextInt();
        sc.nextLine();

        // call the method
        iPO(n);

        int index = -1;

        if (names.contains(tar)) {
            // index will be assigned
            index = names.indexOf(tar);
        }

        // if not found
        System.out.println(index);

        sc.close();
    }
}

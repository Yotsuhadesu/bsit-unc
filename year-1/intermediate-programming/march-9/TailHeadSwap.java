/*
    Elano, Jethro
    De Los Santos, Rhay Airon
    Antonio, Abegail
    Zaragoza, Ian Matthew
 */
import java.util.*;

public class TailHeadSwap {
    public static void main(String[] args) {
        // create LinkedList of Integers
        LinkedList<Integer> nums = new LinkedList<>();    // LinkedList object
        Scanner sc = new Scanner(System.in);    // Scanner object

        // ask how many numbers
        System.out.print("How many numbers: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Add element: ");
            nums.add(sc.nextInt());
        }

        // remove the elements amd assign it variables
        int firstElement = nums.removeFirst();
        int lastElement = nums.removeLast();

        // swap
        nums.addFirst(lastElement);
        nums.addLast(firstElement);

        // print
        System.out.println(nums);

        sc.close();
    }
}

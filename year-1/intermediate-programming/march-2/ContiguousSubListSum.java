/*
    Title: Contiguous Sublist Sum
    Date: 02 March 2026
    Description: A Java program that checks if any consecutive integers of an ArrayList matches the target.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ContiguousSubListSum {
    public static int total(ArrayList<Integer> li) {
        int sum = 0;    // accumulator
        for (int i : li) {
            sum += i;
        }
        return sum;
    }
    public static void main(String[] args) {
        // Contiguous sublist sum
        ArrayList<Integer> li = new ArrayList<>();
        ArrayList<Integer> subLi = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Element " + i + ": ");
            li.add(sc.nextInt());
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();
        int sum;
        boolean found = false;

        // traverse through the list
        for (int i = 0; i < n; i++) {
            if (found) {
                System.out.print("Contiguous sum found: ");
                System.out.println(subLi);
                return;
            }
            for (int j = i; j < n - i; j++) {
                subLi.add(li.get(j));
                sum = total(subLi);

                if (sum == target) {
                    found = true;
                    break;
                } else if (sum > target) {
                    subLi.clear();
                    break;
                }
            }
        }

        System.out.println("No contiguous sum that matched the target.");

        sc.close();
    }
}

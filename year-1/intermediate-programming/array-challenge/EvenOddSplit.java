// Task 4: Elano, Jethro

import java.util.Scanner;

public class EvenOddSplit {
    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many elements? ");    // get the length of the array
        int n = sc.nextInt();

        // arrays
        int[] arr = new int[n];
        int[] even = new int[n];
        int[] odd = new int[n];

        // arr elements
        System.out.println("Array assignment: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        // filter even and odd
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                even[i] = arr[i];
            }
            else {
                odd[i] = arr[i];
            }
        }

        // print
        System.out.println("Even elements: ");
        for (int array : even) {
            if (array == 0)
                continue;
            System.out.print(array + " ");
        }
        System.out.println();
        System.out.println("Odd elements: ");
        for (int array : odd) {
            if (array == 0)
                continue;
            System.out.print(array + " ");
        }

        sc.close();
    }
}

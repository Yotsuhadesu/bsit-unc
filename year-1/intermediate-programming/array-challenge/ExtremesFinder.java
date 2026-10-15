// Task 5: Elano, Jethro

import java.util.Scanner;

public class ExtremesFinder {
    static int maximumIndex (double[] arr) {
        int index = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[index]) {
                index = i;  // replace the current index with an index with higher amount
            }
        }
        return index;
    }
    static int minimumIndex (double[] arr) {
        int index = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[index]) {
                index = i;  // replace the current index with an index with lower amount
            }
        }
        return index;
    }

    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many elements? ");    // get the length of the array
        int n = sc.nextInt();

        // arrays
        double[] arr = new double[n];

        // arr elements
        System.out.println("Array assignment: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        // variables
        int maxIndex = maximumIndex(arr);
        double max = arr[maxIndex];
        int miniIndex = minimumIndex(arr);
        double min = arr[miniIndex];

        // print values
        System.out.println();
        System.out.printf("Maximum: %.2f\n", max);
        System.out.printf("Minimum: %.2f", min);
        sc.close();
    }
}

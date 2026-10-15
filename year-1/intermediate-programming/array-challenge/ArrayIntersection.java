// Task 3: Elano, Jethro

import java.util.Scanner;

public class ArrayIntersection {
    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many elements? ");    // get the length of the array
        int n = sc.nextInt();

        // arrays
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] arr3 = new int[n];

        // arr1 elements
        System.out.println("First array: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr1[i] = sc.nextInt();
        }

        // arr1 elements
        System.out.println("Second array: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr2[i] = sc.nextInt();
        }

        // check if there is a common element
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr1[i] == arr2[j]) {
                    arr3[i] = arr1[i];  // put the common element inside arr3
                }
            }
        }

        // print
        System.out.println("Common elements: ");
        for (int arr : arr3) {
            if (arr == 0)
                continue;
            System.out.print(arr + " ");
        }

        sc.close();
    }
}

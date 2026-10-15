import java.util.Scanner;

public class PrimeFilter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    // Scanner object

        System.out.print("How many elements? ");
        int n = sc.nextInt();

        int[] arr = new int[n];    // sample array
        int[] notPrimeArr = new int[n];

        System.out.println("Array assignment: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == 3) {
                notPrimeArr[i] = arr[i];
            } else if(arr[i] % 2 == 0 || arr[i] % 3 == 0) {
                continue;
            } else {
                notPrimeArr[i] = arr[i];
            }
        }

        // print
        System.out.println("Original array: ");
        for (int array : arr) {
            System.out.print(array + " ");
        }
        System.out.println();
        System.out.println("Filtered array: ");
        for (int array : notPrimeArr) {
            System.out.print(array + " ");
        }

        sc.close();
    }
}

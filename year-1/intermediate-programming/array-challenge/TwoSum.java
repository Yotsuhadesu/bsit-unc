import java.util.Scanner;

public class TwoSum {
    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many elements? ");
        int n = sc.nextInt();
        System.out.print("Target: ");
        int target = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Array assignment: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; i++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println("Output:");
                    System.out.print(arr[i] + " and " + arr[j]);
                }
            }
        }

        sc.close();
    }
}

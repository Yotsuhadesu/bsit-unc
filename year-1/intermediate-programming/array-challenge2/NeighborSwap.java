import java.util.Scanner;

public class NeighborSwap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ask for array length
        System.out.print("How many input? ");
        int n = sc.nextInt();

        int[] arr = new int[n]; // set size

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < arr.length - 1; i++) {
               int temp = arr[i + 1];
               arr[i + 1] = arr[i];
               arr[i] = temp;
               i++;
        }

        // print
        for (int i : arr) {
            System.out.print(i + " ");
        }

        sc.close();
    }
}

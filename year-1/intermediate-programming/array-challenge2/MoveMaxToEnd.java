import java.util.Scanner;

public class MoveMaxToEnd {
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

        // get the largest element
        int h = arr[0];
        for (int i : arr) {
            if (i > h) {
                h = i;
            }
        }

        // move the largest element to the last element by swapping it to its neighbors one by one
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == h) {
                int temp = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = temp;
            }
        }

        // print
        for (int i : arr) {
            System.out.print(i + " ");
        }

        sc.close();
    }
}

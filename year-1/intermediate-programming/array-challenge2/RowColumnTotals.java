import java.util.Scanner;
// Elano, Jethro

public class RowColumnTotals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ask for array row and column length
        System.out.print("How many rows? ");
        int r = sc.nextInt();

        System.out.print("How many columns? ");
        int c = sc.nextInt();

        int[][] arr = new int[r][c]; // set size

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("Row " + (i + 1) + ", column " + (j + 1) + ": ");
                arr[i][j] = sc.nextInt();
            }
        }

        // Sum of elements per row
        System.out.println("Row sum: ");
        for (int i = 0; i < arr.length; i++) {
            int rowSum = 0; // reset
            for (int j = 0; j < arr[i].length; j++) {
                rowSum += arr[i][j];
            }
            System.out.println("Row " + (i + 1) + " sum: " + rowSum);
        }

        // Sum of elements per column
        System.out.println("Column sum:");
        for (int i = 0; i < arr.length; i++) {
            int columnSum = 0;  // reset
            for (int j = 0; j < arr[i].length; j++) {
                columnSum += arr[j][i];
            }
            System.out.println("Column " + (i + 1) + " sum: " + columnSum);
        }

        sc.close();
    }
}

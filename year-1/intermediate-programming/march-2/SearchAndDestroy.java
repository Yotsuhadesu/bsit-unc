/*
    Title: Search and Destroy
    Date: 02 March 2026
    Description: A Java program that replaces the elements of a matrix that matches the target with 0.
 */

import java.util.Scanner;

public class SearchAndDestroy {
    public static void main(String[] args) {
        // Search and Destroy
        Scanner sc = new Scanner(System.in);

        // enter dimensions
        System.out.print("Enter numbers of rows: ");
        int row = sc.nextInt();
        System.out.print("Enter numbers of columns: ");
        int col = sc.nextInt();
        int[][] nums = new int[row][col];

        // declare elements
        System.out.println("Enter matrix elements: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter target number: ");
        int target = sc.nextInt();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (nums[i][j] == target)   // if the current element is equals the target
                    nums[i][j] = 0; // replace with 0
            }
        }

        System.out.println("Updated matrix: ");
        for (int[] i : nums) {  // rows
            for (int j : i) {   // traverse through row
                System.out.print(j + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}

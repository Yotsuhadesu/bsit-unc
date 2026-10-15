/*
    Title: Largest Column Sum Finder
    Date: 16 February 2026
    Description: A Java program that tracks the column with the highest sum in a matrix.
 */
public class LargestSum {
    public static void main(String[] args) {
        int[][] matrix = {
                {3, 8, 2},
                {4, 1, 9},
                {7, 6, 5}
        };


        int sum;
        int maxSum = 0;
        int maxColumn = 0;

        for (int col = 0; col < matrix[0].length; col++) {
            sum = 0;    // reset
            for (int row = 0; row < matrix.length; row++) {
                sum += matrix[row][col];
            }
            if (sum > maxSum) {
                maxColumn = col;
                maxSum = sum;
            }
        }

        System.out.println("Largest sum: Column " + maxColumn + " with sum " + maxSum);
    }
}

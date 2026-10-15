package FInalsPractice;

public class Array {
    public static void main(String[] args) {
        int[][] matrix= {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}

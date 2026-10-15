// Task 2: Elano, Jethro

import java.util.Scanner;

public class ShoppingCartSystem {
    static double totalAmountCalculator(double[] arr) {
        double total = 0;

        for (double array : arr) {
            total += array; // continuously add
        }
        return total;
    }

    static int mostExpensiveIndex (double[] arr) {
        int index = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[index]) {
                index = i;  // replace the current index with an index with higher amount
            }
        }
        return index;
    }

    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many items? ");
        int n = sc.nextInt();

        double[] arr = new double[n];    // sample array
        double[] discountedPrices = new double[n];

        // ask for the prices of each item
        System.out.println("Please input prices: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + ": ");
            arr[i] = sc.nextDouble();
        }

        // deduct discount
        for (int i = 0; i < arr.length; i++) {
            double discountedPrice = arr[i];
            if (arr[i] > 100) {
                discountedPrice = arr[i] - (arr[i] * .1);
            }
            discountedPrices[i] = discountedPrice;
        }

        // variables
        double totalAmount = totalAmountCalculator(discountedPrices);
        int mostIndex = mostExpensiveIndex(discountedPrices);
        double mostExpensive = discountedPrices[mostIndex];

        // print results
        System.out.println();
        System.out.println("Discounted prices: ");
        for (int i = 0; i < discountedPrices.length; i++) {
            System.out.println("Item " + (i + 1) + ": " + discountedPrices[i]);
        }
        System.out.println();
        System.out.printf("Total amount: %.2f\n", totalAmount);
        System.out.printf("Most expensive item: %.2f", mostExpensive);


        sc.close();
    }
}

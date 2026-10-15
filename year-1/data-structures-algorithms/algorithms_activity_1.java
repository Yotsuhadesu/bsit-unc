import java.util.Scanner;

public class algorithms_activity_1 {
    static int mostBorrow(int[] array) {    // get the index of the most borrowed book
        int hIndex = 0;   // initialize tracker

        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[hIndex]) { // if the current element is higher than the current highest
                hIndex = i; // set index
            }
        }
        return hIndex;
    }

    static int leastBorrow(int[] array) {    // get the index of the least borrowed book
        int lIndex = 0;   // initialize tracker

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[lIndex]) { // if the current element is lower than the current lowest
               lIndex = i;  // set index
            }
        }
        return lIndex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    // Scanner object

        // ask for number of books
        System.out.print("Enter the number of books to be tracked: ");
        int nBook = sc.nextInt();

        String[] name = new String[nBook];  // book name storage
        int[] nBorrow = new int[nBook]; // times borrowed storage

        for (int i = 0; i < nBook; i++) {
            sc.nextLine();  // fix bug
            System.out.print("Enter title of book " + (i + 1) + ": ");
            name[i] = sc.nextLine();
            System.out.print("Enter times borrowed: ");
            nBorrow[i] = sc.nextInt();
        }

        // call the methods
        String highBook = name[mostBorrow(nBorrow)];
        int highCount = nBorrow[mostBorrow(nBorrow)];
        String lowBook = name[leastBorrow(nBorrow)];
        int lowCount = nBorrow[leastBorrow(nBorrow)];

        System.out.println();
        // print results
        System.out.println("Book borrowed the most: " + highBook + " (" + highCount + ")");
        System.out.println("Book borrowed the least: " + lowBook + " (" + lowCount + ")");

        sc.close();
    }
}

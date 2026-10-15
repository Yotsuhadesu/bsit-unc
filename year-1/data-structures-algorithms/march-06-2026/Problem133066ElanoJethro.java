/*
    Title: BORROWED BOOK TRACKER
    Date: 06 March 2026
    Description: A Java program that tracks the most and least borrowed books in a month using methods and LinkedList.
*/
import java.util.*; // import all classes

public class Problem133066ElanoJethro {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedList<String> title = new LinkedList<>();  // book title storage
        LinkedList<Integer> borrow = new LinkedList<>();  // borrowed times storage

        askNum();
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("No books borrowed.");
            return;
        }


        for (int i = 0; i < n; i++) {
            eatLine();
            askTitle(i);
            title.add(sc.nextLine());
            askBorrow();
            borrow.add(sc.nextInt());
            newLine();
        }

        int maxIndex = mostBorrow(borrow);
        String maxBook = title.get(maxIndex);
        int maxBorrow = borrow.get(maxIndex);

        System.out.printf("Book borrowed the most: %s (%d)\n", maxBook, maxBorrow);

        int minIndex = leastBorrow(borrow);
        String minBook = title.get(minIndex);
        int minBorrow = borrow.get(minIndex);

        System.out.printf("Book borrowed the least: %s (%d)", minBook, minBorrow);

        sc.close();
    }

    // method with no return and no parameter
    public static void askNum() {
        System.out.print("Enter number of books to be tracked: ");
    }
    public static void askBorrow() {
        System.out.print("Enter times borrowed: ");
    }
    public static void newLine() {
        System.out.println();
    }
    public static void eatLine() {
        sc.nextLine();
    }

    // method with parameter and no return
    public static void askTitle(int i) {
        System.out.printf("Enter title of book %d: ", (i + 1));
    }

    // methods with parameters that returns a value
    public static int mostBorrow(LinkedList<Integer> l) {
        int index = 0;
        int max = Integer.MIN_VALUE;
        int size = l.size();

        for (int i = 0; i < size; i++) {
            int current = l.get(i);
            if (current > max) {
                max = current;
                index = i;
            }
        }

        return index;
    }
    public static int leastBorrow(LinkedList<Integer> l) {
        int index = 0;
        int min = Integer.MAX_VALUE;
        int size = l.size();

        for (int i = 0; i < size; i++) {
            int current = l.get(i);
            if (current < min) {
                min = current;
                index = i;
            }
        }

        return index;
    }
}

package day4;

public class Program {
    public static void main(String[] args) {
        // if else if
        int x = 0;
        if (x < 0) {
            System.out.println("x is a negative number.");
        } else if (x > 0) {
            System.out.println("x is a positive number.");
        } else {
            System.out.println("x is zero.");
        }
        //Write a short loop that prints numbers 1–10, 
        // but skips 5 (using continue) and stops at 8 (using break).
        for (int i = 1; i < 11; i++) {
            if (i == 5) {
                continue;
            } else if (i == 8) {
                break;
            } else {
                System.out.println(i);
            }
        }
    }
}
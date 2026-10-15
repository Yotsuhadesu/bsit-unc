package FInalsPractice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ErrorHandling {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)){
            System.out.print("Integer 1: ");
            int n1 = sc.nextInt();
            System.out.print("Integer 2: ");
            int n2 = sc.nextInt();
            int quotient = n1 / n2;
            System.out.println(quotient);
        } catch (ArithmeticException e) {
            System.out.println("Division by zero detected.");
        } catch (NumberFormatException e) {
            System.out.println("Non-number input detected.");
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input.");
        } finally {
            System.out.println("Operation complete.");
        }
    }
}

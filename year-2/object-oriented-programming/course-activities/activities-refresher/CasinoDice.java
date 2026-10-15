import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class CasinoDice {
    public static int enterStartMoney(Scanner scanner) {
        System.out.print("Enter starting money: ");
        return scanner.nextInt();
    }
    public static int enterBet(Scanner scanner, int balance) {
        System.out.println("Current Balance: " + balance);
        int bet;
        do {
            System.out.print("Enter your bet: ");
            bet = scanner.nextInt();
            if (bet > balance || bet < 1) {
                System.out.println("Please enter a valid bet.");
            }
        } while (bet > balance || bet < 1);
        return bet;
    }
    public static int pickNumber(Scanner scanner) {
        int num;
        do {
            System.out.print("Choose a number (1-6): ");
            num = scanner.nextInt();
            if(num > 6 || num < 1) {
                System.out.println("Please pick a number from 1 to 6.");
            }
        } while(num > 6 || num < 1);
        return num;
    }
    public static int generateRandomNumber() {
        int min = 1;
        int max = 6;
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    public static boolean checkWinCondition(int pickedNum, int randomNum) {
        System.out.println("Your Number: " + pickedNum);
        System.out.println("Generated Number: " + randomNum);
        return pickedNum == randomNum;
    }
    public static void evaluateGame(boolean hasPlayerWon, int bet) {
        if (hasPlayerWon) {
            System.out.println("Congratulations! You won.");
            System.out.println("You earned: " + (bet * 3));
        } else {
            System.out.println("Sorry, you lost " + bet);
        }
    }
    public static boolean willPlayAgain(Scanner scanner, int balance) {
        System.out.print("Play Again? (Y/N) ");
        if (scanner.next().toUpperCase().charAt(0) == 'Y' && balance > 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void endGame(int startMoney, int finalMoney) {
        System.out.println("Thank you for playing!");
        System.out.println("Final Balance: " + finalMoney);
        System.out.println("Starting Balance: " + startMoney);
        if (evaluateWin(startMoney, finalMoney)) {
            System.out.println("You won " + (finalMoney - startMoney) + "! Congratulations!");
        } else {
            System.out.println("Sorry, you lost " + (startMoney - finalMoney) + ".");
        }
    }
    public static boolean evaluateWin(int startMoney, int finalMoney) {
        return finalMoney > startMoney;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startMoney = enterStartMoney(scanner);
        int balance = startMoney;
        do {
            int bet = enterBet(scanner, balance);
            int pickedNum = pickNumber(scanner);
            int randomNum = generateRandomNumber();
            boolean hasPlayerWon = checkWinCondition(pickedNum, randomNum);
            evaluateGame(hasPlayerWon, bet);
            balance += (hasPlayerWon) ? (bet * 3) : -bet;
        } while (willPlayAgain(scanner, balance));
        endGame(startMoney, balance);
        scanner.close();
    }
}

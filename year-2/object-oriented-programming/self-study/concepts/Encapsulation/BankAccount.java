public class BankAccount {
    // encapsulated fields that can't be messed with directly outside the class
    private String accountHolder;
    public double balance;

    // constructor
    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        // validation against negative amounts
        if (balance < 0) {
            System.out.println("You cannot set a negative balance.");
            this.balance = 0.0;
        } else {
            this.balance = balance;
        }
    }

    // set account holder
    public void setAccountHolder(String accountHolder) {
        // validation against null and empty strings
        if (accountHolder == null || accountHolder.isBlank()) {
            System.out.println("Invalid account holder.");
        } else {
            this.accountHolder = accountHolder;
        }
    }

    // check balance
    public double getBalance() {
        return this.balance;
    }

    // deposit
    public void deposit(double balance) {
        // validation against negative amounts
        if (balance < 0) {
            System.out.println("You cannot deposit a negative amount.");
        } else {
            this.balance += balance;
        }
    }

    // withdraw
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("You cannot withdraw a negative amount.");
        } else if (amount > this.balance) {
            System.out.println("You cannot withdraw an amount greater than your current balance.");
            System.out.printf("Balance: %,.2f", this.balance);
        } else {
            System.out.printf("Withdrawn amount: %,.2f\n", amount);
            this.balance -= amount;
            System.out.printf("Current balance: %,.2f", this.balance);
        }
    }
}

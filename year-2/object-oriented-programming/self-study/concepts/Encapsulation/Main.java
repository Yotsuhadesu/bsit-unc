public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Jethro", 5000);

        System.out.println(account.getBalance());
        account.setAccountHolder("   ");
        System.out.println(account.getBalance());
        account.deposit(1000);
        System.out.println(account.getBalance());
        account.withdraw(6000);
    }
}

public interface Payable {
    double TAX_RATE = 0.12;
    double calculateTotal(double amount);
    default void printReceipt(double amount) {
        System.out.printf("Total Amount: %.2f\n", calculateTotal(amount));
    }
}
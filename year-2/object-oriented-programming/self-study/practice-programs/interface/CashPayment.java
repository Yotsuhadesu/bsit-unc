public class CashPayment implements Payable {
    @Override 
    public double calculateTotal(double amount) {
        return amount + (amount * TAX_RATE);
    }
}
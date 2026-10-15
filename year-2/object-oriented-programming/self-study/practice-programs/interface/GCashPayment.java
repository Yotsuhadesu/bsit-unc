public class GCashPayment implements Payable {
    @Override 
    public double calculateTotal(double amount) {
        double total = (amount * TAX_RATE) + amount;
        return total + (total * 0.015);
    }
}
public class CreditCardPayment implements Payable, Refundable {
    @Override 
    public double calculateTotal(double amount) {
        return (amount * TAX_RATE) + 2.5 + amount;
    }
    @Override 
    public double refund(double amount) {
        return amount * .9;
    }
}
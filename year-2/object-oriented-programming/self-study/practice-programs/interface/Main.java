import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Payable> payables = new ArrayList<>();
        payables.add(new CreditCardPayment());
        payables.add(new CashPayment());
        payables.add(new GCashPayment());
        for(Payable payable : payables) {
            payable.printReceipt(1000);
        }
        Refundable refundable = new CreditCardPayment();
        System.out.println(refundable.refund(1000));
    }
}
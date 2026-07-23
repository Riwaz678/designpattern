package strategy;

// Good demo: payment method selected at runtime using Strategy pattern
public class StrategyDemo {

    public static void main(String[] args) {
        PaymentContext context = new PaymentContext(new KhaltiPayment("9800000000"));
        context.payFee(5000);

        context.setPaymentStrategy(new EsewaPayment("9811111111"));
        context.payFee(3000);

        context.setPaymentStrategy(new BankTransferPayment("NRB001234"));
        context.payFee(10000);
    }
}

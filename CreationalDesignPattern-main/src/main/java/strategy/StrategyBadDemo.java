package strategy;

// Bad demo: tight coupling — all logic in one class
public class StrategyBadDemo {

    public static void main(String[] args) {
        PaymentServiceBad service = new PaymentServiceBad();
        service.pay(5000, "KHALTI");
        service.pay(3000, "ESEWA");
        service.pay(10000, "BANK");
    }
}

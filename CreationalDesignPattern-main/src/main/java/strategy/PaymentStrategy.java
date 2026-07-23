package strategy;

// Strategy interface — common contract for all payment methods
public interface PaymentStrategy {
    void pay(double amount);
}

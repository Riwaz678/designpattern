package strategy;

// Bad design: hardcoded payment logic in if-else — adding a new method requires modifying this class
public class PaymentServiceBad {

    public void pay(double amount, String method) {
        if (method.equalsIgnoreCase("KHALTI")) {
            System.out.println("Paid Rs. " + amount + " via Khalti");
        } else if (method.equalsIgnoreCase("ESEWA")) {
            System.out.println("Paid Rs. " + amount + " via eSewa");
        } else if (method.equalsIgnoreCase("BANK")) {
            System.out.println("Paid Rs. " + amount + " via Bank Transfer");
        } else {
            throw new IllegalArgumentException("Invalid payment method: " + method);
        }
    }
}

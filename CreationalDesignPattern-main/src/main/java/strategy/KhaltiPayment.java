package strategy;

// Concrete strategy — pays via Khalti
public class KhaltiPayment implements PaymentStrategy {

    private String mobileNumber;

    public KhaltiPayment(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs. " + amount + " via Khalti (Mobile: " + mobileNumber + ")");
    }

    public String getMobileNumber() { return mobileNumber; }
}

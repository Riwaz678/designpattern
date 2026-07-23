package strategy;

// Concrete strategy — pays via eSewa
public class EsewaPayment implements PaymentStrategy {

    private String mobileNumber;

    public EsewaPayment(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs. " + amount + " via eSewa (Mobile: " + mobileNumber + ")");
    }

    public String getMobileNumber() { return mobileNumber; }
}

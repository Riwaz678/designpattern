package strategy;

// Concrete strategy — pays via Bank Transfer
public class BankTransferPayment implements PaymentStrategy {

    private String accountNumber;

    public BankTransferPayment(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs. " + amount + " via Bank Transfer (Account: " + accountNumber + ")");
    }

    public String getAccountNumber() { return accountNumber; }
}

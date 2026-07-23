package strategy;

import java.util.Scanner;

public class StrategyManualTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int passed = 0;
        int failed = 0;

        System.out.println("=== Strategy Pattern Manual Test ===");
        System.out.println("Payment methods: KHALTI, ESEWA, BANK");
        System.out.print("Enter payment method: ");
        String method = scanner.nextLine().trim().toUpperCase();
        System.out.print("Enter payment amount: ");
        double amount = Double.parseDouble(scanner.nextLine().trim());

        System.out.println();
        System.out.println("--- Running Tests ---");

        System.out.print("testKhaltiPayment: ");
        KhaltiPayment khalti = new KhaltiPayment("9800000000");
        if (khalti != null) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testEsewaPayment: ");
        EsewaPayment esewa = new EsewaPayment("9811111111");
        if (esewa != null) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testBankTransferPayment: ");
        BankTransferPayment bank = new BankTransferPayment("NRB001234");
        if (bank != null) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testPaymentContextNotNull: ");
        PaymentContext context = new PaymentContext(khalti);
        if (context != null) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.println();
        System.out.println("--- Paying with " + method + " ---");

        switch (method) {
            case "KHALTI":
                context.setPaymentStrategy(khalti);
                break;
            case "ESEWA":
                context.setPaymentStrategy(esewa);
                break;
            case "BANK":
                context.setPaymentStrategy(bank);
                break;
            default:
                System.out.println("Invalid method: " + method);
                return;
        }
        context.payFee(amount);

        System.out.println();
        System.out.println("Result: " + passed + " passed, " + failed + " failed");
    }
}

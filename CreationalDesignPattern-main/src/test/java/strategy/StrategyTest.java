package strategy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// JUnit 5 tests to verify Strategy pattern behavior
class StrategyTest {

    @Test
    void testKhaltiPayment() {
        KhaltiPayment khalti = new KhaltiPayment("9800000000");
        assertDoesNotThrow(() -> khalti.pay(5000));
    }

    @Test
    void testEsewaPayment() {
        EsewaPayment esewa = new EsewaPayment("9811111111");
        assertDoesNotThrow(() -> esewa.pay(3000));
    }

    @Test
    void testBankTransferPayment() {
        BankTransferPayment bank = new BankTransferPayment("NRB001234");
        assertDoesNotThrow(() -> bank.pay(10000));
    }

    @Test
    void testPaymentContextNotNull() {
        PaymentContext context = new PaymentContext(new KhaltiPayment("9800000000"));
        assertNotNull(context);
    }

    @Test
    void testSwitchStrategy() {
        PaymentContext context = new PaymentContext(new KhaltiPayment("9800000000"));
        assertDoesNotThrow(() -> context.payFee(5000));

        context.setPaymentStrategy(new EsewaPayment("9811111111"));
        assertDoesNotThrow(() -> context.payFee(3000));
    }

    @Test
    void testKhaltiMobileNumber() {
        KhaltiPayment khalti = new KhaltiPayment("9800000000");
        assertEquals("9800000000", khalti.getMobileNumber());
    }

    @Test
    void testEsewaMobileNumber() {
        EsewaPayment esewa = new EsewaPayment("9811111111");
        assertEquals("9811111111", esewa.getMobileNumber());
    }

    @Test
    void testBankAccountNumber() {
        BankTransferPayment bank = new BankTransferPayment("NRB001234");
        assertEquals("NRB001234", bank.getAccountNumber());
    }
}

package adapter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// JUnit 5 tests to verify Adapter pattern behavior
class AdapterTest {

    @Test
    void testAdapterObjectCreation() {
        LegacyEmailService legacyEmail = new LegacyEmailService();
        EmailAdapter adapter = new EmailAdapter(legacyEmail);
        assertNotNull(adapter);
    }

    @Test
    void testAdapterImplementsNotificationService() {
        LegacyEmailService legacyEmail = new LegacyEmailService();
        NotificationService adapter = new EmailAdapter(legacyEmail);
        assertTrue(adapter instanceof NotificationService);
    }

    @Test
    void testAdapterDelegatesCorrectly() {
        LegacyEmailService legacyEmail = new LegacyEmailService();
        NotificationService adapter = new EmailAdapter(legacyEmail);
        assertDoesNotThrow(() -> adapter.sendNotification("Test message"));
    }

    @Test
    void testAdapterNotNull() {
        LegacyEmailService legacyEmail = new LegacyEmailService();
        NotificationService adapter = new EmailAdapter(legacyEmail);
        assertNotNull(adapter, "Adapter object should not be null");
    }
}

package adapter;

// Bad design: directly calls legacy service — tight coupling, violates interface contract
public class NotificationServiceBad {

    private LegacyEmailService emailService = new LegacyEmailService();

    public void sendNotification(String message) {
        emailService.sendMail(message);
    }
}

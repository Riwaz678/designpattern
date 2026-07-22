package adapter;

// Adapter: bridges old LegacyEmailService to new NotificationService interface
public class EmailAdapter implements NotificationService {

    private LegacyEmailService legacyEmailService;

    public EmailAdapter(LegacyEmailService legacyEmailService) {
        this.legacyEmailService = legacyEmailService;
    }

    @Override
    public void sendNotification(String message) {
        legacyEmailService.sendMail(message);
    }
}

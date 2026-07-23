package adapter;

// Old legacy email service — incompatible interface (sendMail instead of sendNotification)
public class LegacyEmailService {
    public void sendMail(String text) {
        System.out.println("Legacy Email sent: " + text);
    }
}

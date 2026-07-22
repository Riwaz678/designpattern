package adapter;

// Good demo: adapter allows new system to use old service without modifying it
public class AdapterDemo {

    public static void main(String[] args) {
        LegacyEmailService legacyEmail = new LegacyEmailService();
        NotificationService notification = new EmailAdapter(legacyEmail);

        notification.sendNotification("Assignment uploaded");
        notification.sendNotification("Exam starts tomorrow");
    }
}

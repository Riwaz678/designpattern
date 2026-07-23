package adapter;

// Bad demo: tightly coupled to legacy service — no flexibility
public class AdapterBadDemo {

    public static void main(String[] args) {
        NotificationServiceBad service = new NotificationServiceBad();
        service.sendNotification("Assignment uploaded");
    }
}

package adapter;

// New system interface — all notification services must implement this
public interface NotificationService {
    void sendNotification(String message);
}

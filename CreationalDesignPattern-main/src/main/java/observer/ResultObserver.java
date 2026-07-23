package observer;

// Observer interface — all subscribers must implement this
public interface ResultObserver {
    void update(String message);
}

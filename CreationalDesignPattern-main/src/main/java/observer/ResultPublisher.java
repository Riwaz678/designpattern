package observer;

// Subject (Publisher) — notifies all registered observers when result is published
public class ResultPublisher {

    private java.util.List<ResultObserver> observers = new java.util.ArrayList<>();

    public void subscribe(ResultObserver observer) {
        observers.add(observer);
    }

    public void unsubscribe(ResultObserver observer) {
        observers.remove(observer);
    }

    public void publishResult(String result) {
        System.out.println("Result published: " + result);
        for (ResultObserver observer : observers) {
            observer.update(result);
        }
    }

    public int getObserverCount() {
        return observers.size();
    }
}

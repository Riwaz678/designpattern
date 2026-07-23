package state;

// Bad demo: complex if-else logic — hard to add new states
public class StateBadDemo {

    public static void main(String[] args) {
        AdmissionApplicationBad app = new AdmissionApplicationBad();

        app.process();
        app.process();
        app.process();
        app.process();
    }
}

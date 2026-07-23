package state;

// Good demo: state transitions are clean and extensible
public class StateDemo {

    public static void main(String[] args) {
        AdmissionApplication app = new AdmissionApplication();

        System.out.println("Status: " + app.getStatus());
        app.process();

        System.out.println("Status: " + app.getStatus());
        app.process();

        System.out.println("Status: " + app.getStatus());
        app.process();

        System.out.println("Status: " + app.getStatus());
        app.process();

        System.out.println("Status: " + app.getStatus());
    }
}

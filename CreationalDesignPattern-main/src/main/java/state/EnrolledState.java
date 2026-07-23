package state;

// Final state — student enrolled
public class EnrolledState implements AdmissionState {

    @Override
    public void handle(AdmissionApplication application) {
        System.out.println("Student enrolled successfully!");
    }

    @Override
    public String getStatus() {
        return "ENROLLED";
    }
}

package state;

// Context — holds current state and delegates behavior to it
public class AdmissionApplication {

    private AdmissionState currentState;

    public AdmissionApplication() {
        this.currentState = new SubmittedState();
    }

    public void setState(AdmissionState state) {
        this.currentState = state;
    }

    public void process() {
        currentState.handle(this);
    }

    public String getStatus() {
        return currentState.getStatus();
    }
}

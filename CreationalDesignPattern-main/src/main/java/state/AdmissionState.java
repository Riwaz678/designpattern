package state;

// State interface — all admission states must implement this
public interface AdmissionState {
    void handle(AdmissionApplication application);
    String getStatus();
}

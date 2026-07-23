package command;

// Command interface — all requests must implement this
public interface RequestCommand {
    void execute();
    String getDescription();
}

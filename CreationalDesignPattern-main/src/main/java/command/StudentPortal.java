package command;

// Invoker — stores and executes commands
public class StudentPortal {

    private java.util.List<RequestCommand> commandHistory = new java.util.ArrayList<>();

    public void submitRequest(RequestCommand command) {
        commandHistory.add(command);
        command.execute();
    }

    public void processAllRequests() {
        for (RequestCommand command : commandHistory) {
            command.execute();
        }
    }

    public int getRequestCount() {
        return commandHistory.size();
    }

    public java.util.List<RequestCommand> getCommandHistory() {
        return commandHistory;
    }
}

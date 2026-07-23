package command;

// Bad demo: tightly coupled — all logic in one class
public class CommandBadDemo {

    public static void main(String[] args) {
        StudentPortalBad portal = new StudentPortalBad();
        portal.processRequest("TRANSCRIPT", "Ram");
        portal.processRequest("CERTIFICATE", "Ram");
        portal.processRequest("IDCARD", "Ram");
    }
}

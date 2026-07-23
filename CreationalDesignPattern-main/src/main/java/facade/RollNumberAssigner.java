package facade;

public class RollNumberAssigner {
    public String assign(String name) {
        String rollNumber = "ROLL-" + name.toUpperCase().substring(0, 3) + "-2025";
        System.out.println("Roll number assigned: " + rollNumber);
        return rollNumber;
    }
}

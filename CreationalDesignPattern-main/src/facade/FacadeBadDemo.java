package facade;

// Bad design: client must call each subsystem directly — complex and repetitive
public class FacadeBadDemo {

    public static void main(String[] args) {
        StudentValidator validator = new StudentValidator();
        RollNumberAssigner assigner = new RollNumberAssigner();
        StudentRepository repository = new StudentRepository();
        WelcomeMessageService welcomeService = new WelcomeMessageService();

        String name = "Ram";
        String id = "S101";

        if (validator.validate(name, id)) {
            String rollNumber = assigner.assign(name);
            repository.save(name, id, rollNumber);
            welcomeService.send(name);
        }
    }
}

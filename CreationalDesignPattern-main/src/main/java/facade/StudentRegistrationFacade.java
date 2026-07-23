package facade;

// Facade: single method handles all subsystem complexity
public class StudentRegistrationFacade {

    private StudentValidator validator = new StudentValidator();
    private RollNumberAssigner assigner = new RollNumberAssigner();
    private StudentRepository repository = new StudentRepository();
    private WelcomeMessageService welcomeService = new WelcomeMessageService();

    public boolean register(String name, String id) {
        if (!validator.validate(name, id)) {
            return false;
        }

        String rollNumber = assigner.assign(name);
        repository.save(name, id, rollNumber);
        welcomeService.send(name);
        return true;
    }
}

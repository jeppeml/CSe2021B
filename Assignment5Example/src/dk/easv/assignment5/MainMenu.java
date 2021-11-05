package dk.easv.assignment5;

public class MainMenu extends Menu{
    private PersonManager pm;
    /**
     * Creates an instance of the class with the given header text and
     * menu options.
     *
     */
    public MainMenu(PersonManager pm) {
        super("Main Menu",
                "Teacher administration",
                "Student administration");
        this.pm = pm;
    }

    @Override
    protected void doAction(int option) {
        if(option==1){
            new TeacherMenu(pm).run();
        }
        else if(option==2){
            new StudentMenu(pm).run();
        }
        else if (option!=0)
            throw new RuntimeException("Action does not exist, error in program");
    }

}

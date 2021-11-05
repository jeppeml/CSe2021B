package dk.easv.assignment5;

import java.util.Scanner;

public class TeacherMenu extends Menu{
    private PersonManager pm;

    /**
     * Creates an instance of the class with the given header text and
     * menu options.
     *
     */
    public TeacherMenu(PersonManager pm) {
        super("Teacher Menu",
                "Add teacher",
                "Remove Teacher",
                "Show teacher information",
                "Show all Teachers");
        this.pm=pm;
    }

    @Override
    protected void doAction(int option) {
        Scanner sc = new Scanner(System.in);
        if(option==1){
            System.out.print("Teacher id: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.println();
            System.out.print("Teacher name: ");
            String name = sc.nextLine();
            System.out.print("Teacher initials: ");
            String initials = sc.nextLine();
            pm.addPerson(new Teacher(id, name, initials));
            System.out.println("Teacher added...");
        }
        else if(option==2){// remove teacher
            System.out.print("Please type teacher id you want to remove");
            int id = Integer.parseInt(sc.nextLine());
            System.out.println();
            pm.removePerson(id);
            System.out.println("teacher has been removed");
        }
        else if(option==3){// teacher info
            System.out.print("Please type teacher id you want to see");
            int id = Integer.parseInt(sc.nextLine());
            System.out.println();
            System.out.println(pm.getPerson(id));
        }
        else if(option==4){// all teachers
            System.out.println("All teachers: ");
            System.out.println( "ID\t\t\t\t" + "NAME\t\t\t\t" + "EMAIL");
            for (Person p: pm.getAllTeachers()) {
                System.out.println(p);
            }
        }
        else if (option!=0)
            throw new RuntimeException("Action does not exist, error in program");

    }

}

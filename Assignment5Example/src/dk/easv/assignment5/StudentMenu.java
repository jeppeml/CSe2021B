package dk.easv.assignment5;

import java.util.List;
import java.util.Scanner;


public class StudentMenu extends Menu{
    private PersonManager pm;

    public StudentMenu(PersonManager pm) {
        super("Student Menu",
                "Add student",
                "Remove student",
                "See student informaion",
                "Show all students");
        this.pm=pm;
        GO("go")
    }

    @Override
    protected void doAction(int option) {
        Scanner sc = new Scanner(System.in);
        if(option==1){ // add student
            System.out.print("Student id: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.println();
            System.out.print("Student name: ");
            String name = sc.nextLine();
            System.out.print("Student education: ");
            String education = sc.nextLine();
            pm.addPerson(new Student(id, name,education));
            System.out.println("Student added...");
        }
        else if(option==2){ // remove student
            System.out.print("Please type student id you want to remove");
            int id = Integer.parseInt(sc.nextLine());
            System.out.println();
            pm.removePerson(id);
            System.out.println("Student has been removed");
        }
        else if(option==3){// student info
            System.out.print("Please type student id you want to see");
            int id = Integer.parseInt(sc.nextLine());
            System.out.println();
            System.out.println(pm.getPerson(id));
        }
        else if(option==4){// all students
            System.out.println("All students: ");
            System.out.println( "ID\t\t\t\t" + "NAME\t\t\t\t" + "EMAIL");
            for (Person p: pm.getAllStudents()) {
                System.out.println(p);
            }
        }
        else if (option!=0)
            throw new RuntimeException("Action does not exist, error in program");

    }
}

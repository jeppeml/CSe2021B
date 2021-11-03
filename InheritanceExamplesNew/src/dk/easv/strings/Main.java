package dk.easv.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int inputNumber = -1;
        while(inputNumber<0 || inputNumber>6){
            System.out.println("Please input a number (0-6)");
            try{
                String input = sc.nextLine();
                inputNumber = Integer.parseInt(input);
            }
            catch (NumberFormatException e){
                System.out.println("Put a number");
            }
            if(inputNumber<0 || inputNumber>6)
                System.out.println("Number must be between 0 and 6");
        }
        System.out.println("You selected:  " + inputNumber);
        /*
        List<Named> persons = new ArrayList<>();
       // Person p = new Person("Peter");
	    Teacher t = new Teacher("Piotr Stegonovskij", 1337);
        Student s = new Student("Pete Stegga", -3);
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
        persons.add(t);
        persons.add(s);

        for (Named p : persons){
            System.out.println(p.getName());
        }*/
    }
}

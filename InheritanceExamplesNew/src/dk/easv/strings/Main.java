package dk.easv.strings;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

	    Teacher t = new Teacher("Piotr Stegonovskij", 1337);
        Student s = new Student("Pete Stegga", -3);

        persons.add(t);
        persons.add(s);

        for (Person p : persons){
            System.out.println(p);
        }
    }
}

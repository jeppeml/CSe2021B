package dk.easv.assignment5;

import java.util.*;

public class Test {
    List<Person> persons = new ArrayList<>();
    public void runTests(){
        Person piotr = new Person(666, "Piotr Stegonovski");
        piotr.setEmail("piotr@hotmail.com");

        Person pete = new Person(1, "Pete Stegga");
        pete.setEmail("pete44@hotmail.com");

        Person hans = new Person(2, "Hans Nielsen");
        hans.setEmail("hnisdf@easv.dk");

        persons.add(piotr);
        persons.add(pete);
        persons.add(hans);


        System.out.println( "ID\t\t\t\t" + "NAME\t\t\t\t" + "EMAIL");



        Teacher t1000 = new Teacher(1000, "Svend Swillo", "ss");
        t1000.setEmail("ss@easv.dk");
        t1000.getSubjects().add("ITO");
        t1000.getSubjects().add("Security");

        Teacher tbhp = new Teacher(202, "Bent H. Pedersen", "bhp");
        tbhp.setEmail("bhp@easv.dk");
        tbhp.getSubjects().add("Programming");
        tbhp.getSubjects().add("Robots");

        persons.add(t1000);
        persons.add(tbhp);

        System.out.println("All persons:");
        for(Person p : persons){
            System.out.println(p);
        }
        System.out.println("This is a test");
    }
}

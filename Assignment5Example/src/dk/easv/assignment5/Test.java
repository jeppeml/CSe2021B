package dk.easv.assignment5;

import java.util.*;

public class Test {
    //List<Person> persons = new ArrayList<>();
    public void runTests(){
        PersonManager pm = new PersonManager();
/*
        Person piotr = new Person(666, "Piotr Stegonovski");
        piotr.setEmail("piotr@hotmail.com");

        Person pete = new Person(1, "Pete Stegga");
        pete.setEmail("pete44@hotmail.com");

        Person hans = new Person(2, "Hans Nielsen");
        hans.setEmail("hnisdf@easv.dk");

        pm.addPerson(piotr);
        pm.addPerson(pete);
        pm.addPerson(hans);
*/

        System.out.println( "ID\t\t\t\t" + "NAME\t\t\t\t" + "EMAIL");



        Teacher t1000 = new Teacher(1000, "Svend Swillo", "ss");
        t1000.setEmail("ss@easv.dk");
        t1000.getSubjects().add("ITO");
        t1000.getSubjects().add("Security");

        Teacher tbhp = new Teacher(202, "Bent H. Pedersen", "bhp");
        tbhp.setEmail("bhp@easv.dk");
        tbhp.getSubjects().add("Programming");
        tbhp.getSubjects().add("Robots");

        pm.addPerson(t1000);
        pm.addPerson(tbhp);

        Student per = new Student(6, "Per Persson", "CS");
        per.addGrade(new GradeInfo("Programming",02));
        per.addGrade(new GradeInfo("ITO",12));
        per.addGrade(new GradeInfo("Network",7));
        per.addGrade(new GradeInfo("Final Project",-3));

        Student brian = new Student(7, "Brian Mortonsson", "MMD");
        brian.addGrade(new GradeInfo("Programming",4));
        brian.addGrade(new GradeInfo("ITO",7));
        brian.addGrade(new GradeInfo("GUI design",10));
        brian.addGrade(new GradeInfo("UX",12));

        pm.addPerson(per);
        pm.addPerson(brian);

        System.out.println("All persons:");
        for(Person p : pm.getAllPersons()){
            System.out.println(p);
        }

        System.out.println("Students only:");
        for(Person p : pm.getAllStudents()){
            System.out.println(p);
        }

        System.out.println("Teachers only:");
        for(Person p : pm.getAllTeachers()){
            System.out.println(p);
        }
        System.out.println("This is a test");
    }
}

package dk.easv.assignment5;

import java.util.*;

public class Test {
    public void fillMockData(PersonManager pm){


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
    }

    public void printTests(PersonManager pm){

        System.out.println( "ID\t\t\t\t" + "NAME\t\t\t\t" + "EMAIL");

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

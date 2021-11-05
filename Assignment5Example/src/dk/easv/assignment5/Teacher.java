package dk.easv.assignment5;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person{
    private List<String> subjects;
    private String initials;
    private double salary;

    public Teacher(int id, String name, String initials) {
        super(id, name);
        subjects = new ArrayList<>();
        this.initials = initials;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public String getInitials() {
        return initials;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        String subjects = "";
        if(getSubjects().size()>0)
            subjects = getSubjects().get(0);
        return super.toString() + "\t\t" + getInitials() + "\t\t" + subjects;
    }
}

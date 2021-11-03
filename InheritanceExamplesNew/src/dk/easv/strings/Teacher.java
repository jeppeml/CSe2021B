package dk.easv.strings;

public class Teacher extends Person{
    double salary;
    public Teacher(String name) {
        super(name);
    }
    public Teacher(String name, double salary) {
        super(name);
        this.salary=salary;
    }
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", salary: " + getSalary();
    }
    @Override
    public String getName() {
        return "Cool person: " + super.name;
    }

    @Override
    public void setName(String name) {
        super.name = name;
    }
}

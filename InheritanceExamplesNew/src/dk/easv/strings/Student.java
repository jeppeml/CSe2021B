package dk.easv.strings;

public class Student extends Person{
    public int grade;
    public Student(String name) {
        super(name);
    }

    public Student(String name, int grade) {
        super(name);
        setGrade(grade);
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        if(grade>12 || grade<-3)
            throw new RuntimeException("Wrong grade!");
        if(grade==-1 || grade == -2 || grade == 1)
            throw new RuntimeException("Wrong grade!");
        this.grade = grade;
    }

    @Override
    public String toString() {
        return super.toString() + ", grade: " + getGrade();
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public void setName(String name) {
        super.name = name;
    }
}

package dk.easv.assignment5;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person{
    private String education;
    private List<GradeInfo> gradeReport;

    public Student(int id, String name, String education) {
        super(id, name);
        gradeReport = new ArrayList<>();
        this.education = education;
    }

    public double getAverageGrade(){
        double sum = 0.0;
        for(GradeInfo gi : gradeReport){
            sum = sum + gi.getGrade();
        }
        return sum/gradeReport.size();
    }

    public int getGrade(String subject){
        for(GradeInfo gi : gradeReport){
            if(subject.equals(gi.getSubject())){
                return gi.getGrade();
            }
        }
        return -4;
    }

    public void addGrade(GradeInfo gradeInfo){
        gradeReport.add(gradeInfo);
    }

    public String getEducation() {
        return education;
    }

    public List<GradeInfo> getGradeReport() {
        return gradeReport;
    }
    @Override
    public String toString() {
        return super.toString() + "\t\t" + getEducation() + "\t\t" + getAverageGrade();
    }

}
package dk.easv.assignment5;

import java.util.ArrayList;
import java.util.List;

public class PersonManager {
    private List<Person> persons = new ArrayList<>();

    public Person getPerson(int id){
        for(Person p:persons)
            if(p.getId() == id)
                return p;

        return null;
    }

    public void addPerson(Person p){
        boolean exist = false;
        for(Person person : persons){
            if(person.equals(p))
            {
                exist = true;
                break;
            }
        }
        if(!exist)
            persons.add(p);
        else{
            throw new RuntimeException("Person with that id is already in the list");
        }
    }
    public void removePerson(int id){
        for (int i = 0; i <persons.size(); i++) {
            if(persons.get(i).getId() == id) {
                persons.remove(persons.get(i));
                break;
            }
        }
    }

    public List<Person> getAllPersons(){
        return persons;
    }

    public List<Person> getAllStudents(){
        List<Person> studentsOnly = new ArrayList<>();
        for(Person p: persons){
            if(p instanceof Student)
                studentsOnly.add(p);
        }
        return studentsOnly;
    }

    public List<Person> getAllTeachers(){
        List<Person> teachersOnly = new ArrayList<>();
        for(Person p: persons){
            if(p instanceof Teacher)
                teachersOnly.add(p);
        }
        return teachersOnly;
    }

}

package dk.easv.assignment5;

public abstract class Person {
    private int id;
    private String name;
    private String email;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        Person compPerson = (Person) obj;
        return compPerson.getId() == this.getId();
    }

    @Override
    public String toString() {
        return getId() + "\t\t" + getName() + "\t\t\t\t" + getEmail();
    }
}

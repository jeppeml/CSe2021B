package dk.easv.strings;

import java.io.Serializable;

public abstract class Person implements Named {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "Person, name: " + name;
    }

}

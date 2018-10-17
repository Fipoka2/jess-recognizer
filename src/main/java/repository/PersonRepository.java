package repository;

import java.util.ArrayList;

import model.Person;

public class PersonRepository {

    private ArrayList<Person> persons;

     public PersonRepository() {
         this.persons = new ArrayList<>();
     }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }
}

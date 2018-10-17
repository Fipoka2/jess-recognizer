package repository;

import java.util.ArrayList;

import model.Person;

public class PersonRepository {

    private ArrayList<Person> persons;

    private static PersonRepository instance;

    private PersonRepository() {
        persons = new ArrayList<>();
    }

    public static PersonRepository getInstance() {
        if (instance == null) {
            instance = new PersonRepository();
        }
        return instance;
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }
}

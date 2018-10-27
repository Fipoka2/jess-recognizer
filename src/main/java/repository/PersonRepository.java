package repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Person;

public class PersonRepository {

    private ObservableList<Person> persons;

    private static PersonRepository instance;

    private PersonRepository() {
        persons = FXCollections.observableArrayList();
    }

    public static PersonRepository getInstance() {
        if (instance == null) {
            instance = new PersonRepository();
        }
        return instance;
    }

    public ObservableList<Person> getPersons() {
        return persons;
    }
}

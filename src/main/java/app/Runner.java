package app;

import model.Person;
import repository.PersonRepository;

/**
 * Костыль для запуска модульного приложения*/
public class Runner {

    public static void main(String[] args) {
        PersonRepository rep = PersonRepository.getInstance();
        rep.getPersons().add(new Person("lol"));
        App.main(args);
    }
}

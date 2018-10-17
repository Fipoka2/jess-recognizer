package app;

import model.Person;
import repository.PersonRepository;
import repository.RepositoryManager;

/**
 * Костыль для запуска модульного приложения*/
public class Runner {

    public static void main(String[] args) {
        PersonRepository rep = RepositoryManager.getInstance().getRepository();
        rep.getPersons().add(new Person("lol"));
        App.main(args);
    }
}

package app;

import repository.PersonRepository;

/**
 * Костыль для запуска модульного приложения*/
public class Runner {

    public static void main(String[] args) {
        PersonRepository rep = PersonRepository.getInstance(); //init repo
        Root.main(args);
    }
}

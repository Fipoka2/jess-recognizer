package repository;

public class RepositoryManager {

    private static RepositoryManager instance;

    private PersonRepository repository;

    private RepositoryManager() {
        repository = new PersonRepository();
    }
    public static RepositoryManager getInstance() {
        if (instance == null) {
            instance = new RepositoryManager();
        }
        return instance;
    }

    public PersonRepository getRepository() {
        return repository;
    }
}

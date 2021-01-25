package demo;

public class Service {

    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    void save(Integer number) {
        repository.saveEntity(number);
    }
}

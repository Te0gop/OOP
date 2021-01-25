package demo;

public class Configuration {
    private static Repository repository() {
        return new Repository();
    }

    public static Service service() {
        return new Service(repository());
    }
}

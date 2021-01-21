package singleton_pattern;

public class Main {

    public static void main(String[] args) {
        SingletonCounter singleton = SingletonCounter.getInstance();
        singleton.getCounter().put("Sofia", 2000000);
        int capital = singleton.getPopulationCount(singleton.getCounter(), "Sofia");

        System.out.println(capital);

    }

}

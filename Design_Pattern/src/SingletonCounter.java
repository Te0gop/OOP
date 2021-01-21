import java.util.HashMap;
import java.util.Map;

public class SingletonCounter implements Singleton {

    private static SingletonCounter instance;
    Map<String, Integer> counter;

    private SingletonCounter() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.counter = new HashMap<>();
    }

    public static SingletonCounter getInstance() {
        if(instance == null) {
            instance = new SingletonCounter();
        }
        return instance;
    }

    @Override
    public int getPopulationCount(Map<String, Integer> population, String name) {
        return population.get(name);
    }

    public Map<String, Integer> getCounter() {
        return counter;
    }
}

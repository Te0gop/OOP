package annotations.problem_05.coding_tracker;
import java.lang.reflect.Method;
import java.util.*;

public class Tracker {
    @Author(name = "George")
    public static void main(String[] args) {
        Tracker.printMethodByAuthor(Tracker.class);
    }

    @Author(name = "Peter")
    public static void printMethodByAuthor(Class<?> cl) {

        Map<String, List<String>> methodsByAuthor = new HashMap<>();
        Method[] methods = cl.getDeclaredMethods();

        for (Method method : methods) {
            Author annotation = method.getAnnotation(Author.class);
            if(annotation != null) {
                methodsByAuthor.putIfAbsent(annotation.name(), new ArrayList<>());
                methodsByAuthor.get(annotation.name()).add(method.getName() + "()");
            }
        }
        methodsByAuthor.forEach((key, value) -> {
            System.out.print(key + ": ");
            value.forEach(x -> System.out.print(x + " "));
            System.out.println();

        });

    }
}

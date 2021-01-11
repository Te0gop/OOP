package reflection.problem_02.getters_and_setters;

import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> reflection = Reflection.class;

        Method[] methods = reflection.getDeclaredMethods();

        Map<String, String> getters = new TreeMap<>();
        Map<String, String> setters = new TreeMap<>();

        for (Method method : methods) {
            if(!method.getReturnType().equals(void.class)) {
                getters.put(method.getName(), method.getReturnType().getSimpleName());
            } else {
                setters.put(method.getName(), method.getParameterTypes()[0].getSimpleName());
            }
        }

        getters.forEach((key, value) -> System.out.println(key + " will return class " + value));
        setters.forEach((key, value) -> System.out.println(key + " and will set field of class " + value));

    }
}

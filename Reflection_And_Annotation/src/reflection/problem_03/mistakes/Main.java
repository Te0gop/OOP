package reflection.problem_03.mistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> reflection = Reflection.class;

        Set<String> modifiers = new TreeSet<>();
        Set<String> getters = new TreeSet<>();
        Set<String> setters = new TreeSet<>();

        Method[] methods = reflection.getDeclaredMethods();
        Field[] fields = reflection.getDeclaredFields();

        for (Field field : fields) {
            int mod = field.getModifiers();
            if(!Modifier.isPrivate(mod)) {
                modifiers.add(field.getName());
            }
        }

        for (Method method : methods) {
            if(method.getName().startsWith("get") && !Modifier.isPublic(method.getModifiers())) {
                getters.add(method.getName());
            } else if (method.getName().startsWith("set") && !Modifier.isPrivate(method.getModifiers())) {
                setters.add((method.getName()));
            }
        }

        modifiers.forEach(x -> System.out.println(x + " must be private!"));
        getters.forEach(x -> System.out.println(x + " have to be public!"));
        setters.forEach(x -> System.out.println(x + " have to be private!"));

    }
}

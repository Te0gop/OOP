package reflection.problem_01.reflection;

import java.lang.reflect.InvocationTargetException;


public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Reflection> reflection = Reflection.class;

        System.out.println(reflection);
        System.out.println(reflection.getSuperclass());

        Class[] interfaces = reflection.getInterfaces();

        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

        Object reflectionObj = reflection.getDeclaredConstructor().newInstance();
        System.out.println(reflectionObj);


    }
}

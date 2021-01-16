package reflection.problem_02.box;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException, NoSuchFieldException {

        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> blackBox = BlackBoxInt.class;

        Constructor<BlackBoxInt> constructor = blackBox.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();
        Field innerValue = blackBoxInt.getClass().getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        String line;

        while(!(line = scanner.nextLine()).equals("END")) {
            try {
                int boxValue = getMethod(line, blackBoxInt, innerValue);
                System.out.println(boxValue);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static int getMethod(String input, Object blackBoxInt, Field innerValue)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        String[] delimiter = input.split("_");
        String command = delimiter[0];
        int value = Integer.parseInt(delimiter[1]);

        Method add = blackBoxInt.getClass().getDeclaredMethod(command, int.class);
        add.setAccessible(true);
        add.invoke(blackBoxInt, value);
        return innerValue.getInt(blackBoxInt);
    }
}

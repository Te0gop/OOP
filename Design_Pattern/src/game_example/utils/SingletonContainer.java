package game_example.utils;

import game_example.commands.Command;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class SingletonContainer {
    private static Map<String, Command> commandsByNames;

    private SingletonContainer() {

    }

    private static void init() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // First way:
//        commandsByNames = new HashMap<>();
//        commandsByNames.put("game_example.commands.Attack", new game_example.commands.Attack());
//        commandsByNames.put("game_example.commands.Defend", new game_example.commands.Defend());
//        commandsByNames.put("game_example.commands.Run", new game_example.commands.Run());
//        commandsByNames.put("game_example.commands.Move", new game_example.commands.Move());
//        commandsByNames.put("game_example.commands.Lose", new game_example.commands.Lose());

        // Second way with reflection:
        File file = new File("D:\\Workspace Git\\OOP\\Design_Pattern\\src\\game_example\\commands");
        File[] files = file.listFiles();

        for (File f : files) {

            if (f.getName().equals("Command")) {
                continue;
            }

            Class<?> clazz = Class.forName(("game_example.commands." + f.getName()).replaceAll(".java", ""));
            Constructor<?> constructor = clazz.getDeclaredConstructor();

            Command command = (Command) constructor.newInstance();
            commandsByNames.put(f.getName().replaceAll(".java", ""), command);

        }
    }

    public static Map<String, Command> getCommands() {
        if (commandsByNames == null) {
            try {
                init();
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
            }
        }
        return commandsByNames;
    }

    public static void setCommandsByNames(Map<String, Command> commandsByNames) {
        SingletonContainer.commandsByNames = commandsByNames;
    }
}

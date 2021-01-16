package barracksWars.core;

import barracksWars.core.commands.Command;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Runnable;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Engine implements Runnable {

	private static final String UNITS_PACKAGE_NAME = "barracksWars.core.commands.";

	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
				System.out.println(e.getMessage());
			} catch (IOException | ExecutionControl.NotImplementedException e) {
				e.printStackTrace();
			}
		}
	}

	// TODO: refactor for problem 4
	private String interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		String result;
		commandName = commandName.substring(0, 1).toUpperCase()
				+ commandName.substring(1) + "Command";

		Class<?> aClass = Class.forName(UNITS_PACKAGE_NAME + commandName);
		Object o = aClass.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class)
				.newInstance(data, repository, unitFactory);
		Command cmd = (Command) o;
		Method execute = aClass.getDeclaredMethod("execute");
		result = execute.invoke(cmd).toString();

		return result;
	}

}

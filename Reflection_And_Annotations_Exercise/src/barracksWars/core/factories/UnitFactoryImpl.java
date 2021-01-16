package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import barracksWars.models.units.*;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME = "barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException{

		try {
			Class<?> clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
			clazz.getDeclaredConstructor().setAccessible(true);
			return (AbstractUnit) clazz.getDeclaredConstructor().newInstance();
		} catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
				InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

		throw new ExecutionControl.NotImplementedException("There is no such unit!");
	}
}

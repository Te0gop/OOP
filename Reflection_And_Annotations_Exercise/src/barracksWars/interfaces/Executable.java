package barracksWars.interfaces;

import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public interface Executable {

	String execute() throws NoSuchMethodException, InstantiationException, ExecutionControl.NotImplementedException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchFieldException;

}

package barracksWars.core.commands;

import barracksWars.data.UnitRepository;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class RetireCommand extends Command{
    public RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        getRepository().removeUnit(getData()[1]);

        Class<UnitRepository> obj = UnitRepository.class;
        UnitRepository repo = obj.getDeclaredConstructor().newInstance();

        Field field = repo.getClass().getDeclaredField("amountOfUnits");
        field.setAccessible(true);

        Map<String, Integer> map = (Map<String, Integer>)field.get(repo);

        if(!map.containsKey(getData()[1])) {
            throw new ExecutionControl.NotImplementedException("No such units in repository.");
        }
        return getData()[1] + " retired!";
    }
}

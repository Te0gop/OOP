package CounterStriker.repositories;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.GunImpl;

import java.util.*;

public class GunRepository extends ExceptionMessages implements Repository {

    private List<Gun> models;

    public GunRepository() {
        this.models = new LinkedList<>();
    }

    @Override
    public Collection getModels() {
        return models;
    }

    @Override
    public void add(Object model) {
        if(model == null) {
            throw new NullPointerException(INVALID_GUN_REPOSITORY);
        }
        this.models.add((GunImpl) model);
    }

    @Override
    public boolean remove(Object model) {
        if(models.contains((GunImpl) model)) {
            models.remove(model);
            return true;
        }
        return false;
    }

    @Override
    public Object findByName(String name) {
        return this.models.stream()
                .filter(p->p.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

}

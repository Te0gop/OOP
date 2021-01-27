package CounterStriker.repositories;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.PlayerImpl;

import java.util.*;
import java.util.stream.Collectors;

public class PlayerRepository extends ExceptionMessages implements Repository{

    private List<Player> models;

    public PlayerRepository() {
        this.models = new LinkedList<>();
    }

    @Override
    public Collection getModels() {
        return models;
    }

    @Override
    public void add(Object model) {
        if(model == null) {
            throw new NullPointerException(INVALID_PLAYER_REPOSITORY);
        }
        this.models.add((PlayerImpl) model);
    }

    @Override
    public boolean remove(Object model) {
        if(models.contains((PlayerImpl) model)) {
            models.remove(model);
            return true;
        }
        return false;
    }

    @Override
    public Object findByName(String name) {
        return this.models.stream()
                .filter(p->p.getUsername().equals(name))
                .findFirst()
                .orElse(null);
    }
}

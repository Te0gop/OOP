package src.robotService.models.garages;

import src.robotService.common.ExceptionMessages;
import src.robotService.models.garages.interfaces.Garage;
import src.robotService.models.robots.interfaces.Robot;

import java.util.LinkedHashMap;
import java.util.Map;

public class GarageImpl extends ExceptionMessages implements Garage {
    private final int CAPACITY = 10;
    private Map<String, Robot> robots;

    public GarageImpl() {
        this.robots = new LinkedHashMap<>();
    }

    @Override
    public Map<String, Robot> getRobots() {
        return robots;
    }

    @Override
    public void manufacture(Robot robot) {
        if(this.robots.size() > CAPACITY) {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY);
        } else if(this.robots.containsKey(robot.getName())) {
            throw new IllegalArgumentException(EXISTING_ROBOT + robot.getName());
        }
        this.robots.put(robot.getName(), robot);
    }

    @Override
    public void sell(String robotName, String ownerName) {
        if(!this.robots.containsKey(robotName)) {
            throw new IllegalArgumentException(NON_EXISTING_ROBOT + robotName);
        }
        this.robots.get(robotName).setOwner(ownerName);
        this.robots.get(robotName).setBought(true);
        this.robots.remove(robotName);
    }

}

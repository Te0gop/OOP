package src.robotService.models.procedures;

import src.robotService.models.robots.interfaces.Robot;

import java.util.ArrayList;

public class Repair extends BaseProcedure {

    @Override
    public void doService(Robot robot, int procedureTime) {
        super.doService(robot, procedureTime);
        if(robot.isRepaired()) {
            throw new IllegalArgumentException(robot.getName() + " is already repaired");
        }
        robot.setHappiness(robot.getHappiness() - 5);
        robot.setRepaired(true);
        if(super.robots.containsKey(this.getClass().getSimpleName())) {
            super.robots.get(this.getClass().getSimpleName()).add(robot);
        } else {
            super.robots.put(this.getClass().getSimpleName(), new ArrayList<>(){{add(robot);}});
        }
    }
}

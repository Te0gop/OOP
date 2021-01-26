package src.robotService.models.procedures;

import src.robotService.models.robots.interfaces.Robot;

import java.util.ArrayList;

public class Work extends BaseProcedure{

    @Override
    public void doService(Robot robot, int procedureTime) {
        super.doService(robot, procedureTime);
        robot.setHappiness(robot.getHappiness() + 12);
        robot.setEnergy(robot.getEnergy() - 6);
        if(super.robots.containsKey(this.getClass().getSimpleName())) {
            super.robots.get(this.getClass().getSimpleName()).add(robot);
        } else {
            super.robots.put(this.getClass().getSimpleName(), new ArrayList<>(){{add(robot);}});
        }

    }
}

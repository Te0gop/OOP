package src.robotService.models.procedures.interfaces;

import src.robotService.models.robots.interfaces.Robot;

public interface Procedure {
    String history();

    void doService(Robot robot, int procedureTime);
}

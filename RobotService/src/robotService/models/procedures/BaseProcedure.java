package src.robotService.models.procedures;

import src.robotService.common.ExceptionMessages;
import src.robotService.models.procedures.interfaces.Procedure;
import src.robotService.models.robots.interfaces.Robot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseProcedure extends ExceptionMessages implements Procedure {

    protected Map<String, List<Robot>> robots;

    public BaseProcedure() {
        this.robots = new HashMap<>();
    }

    @Override
    public String history() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.getClass().getSimpleName());

        for (Map.Entry<String, List<Robot>> entry : robots.entrySet()) {
            for (Robot value : entry.getValue()) {
                sb.append(System.lineSeparator());
                sb.append(value.toString());
            }
        }
        return sb.toString();
    }

    @Override
    public void doService(Robot robot, int procedureTime) {
        if(robot.getProcedureTime() - procedureTime <= 0) {
            throw new IllegalArgumentException(INSUFFICIENT_PROCEDURE_TIME);
        }
        robot.setProcedureTime(robot.getProcedureTime() - procedureTime);
    }
}

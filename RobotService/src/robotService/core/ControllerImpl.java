package src.robotService.core;

import src.robotService.common.OutputMessages;
import src.robotService.core.interfaces.Controller;
import src.robotService.models.garages.GarageImpl;
import src.robotService.models.garages.interfaces.Garage;
import src.robotService.models.procedures.Charge;
import src.robotService.models.procedures.Repair;
import src.robotService.models.procedures.Work;
import src.robotService.models.robots.BaseRobot;
import src.robotService.models.robots.Cleaner;
import src.robotService.models.robots.Housekeeper;

public class ControllerImpl extends OutputMessages implements Controller{

    private Garage garage;
    private Charge charge;
    private Repair repair;
    private Work work;

    public ControllerImpl() {
        this.garage = new GarageImpl();
        this.charge = new Charge();
        this.repair = new Repair();
        this.work = new Work();
    }

    @Override
    public String manufacture(String robotType, String name, int energy, int happiness, int procedureTime) {
        BaseRobot robot = null;

        if(robotType.equals("Cleaner")) {
            robot = new Cleaner(name, energy, happiness, procedureTime);
        } else if (robotType.equals("Housekeeper")) {
            robot = new Housekeeper(name, energy, happiness, procedureTime);
        } else {
            throw new IllegalArgumentException(robotType + " type does not exist");
        }
        garage.manufacture(robot);
        return String.format(ROBOT_MANUFACTURED, name);
    }

    @Override
    public String repair(String robotName, int procedureTime) {
        nameValidator(robotName);
        this.repair.doService(garage.getRobots().get(robotName), procedureTime);
        return String.format(REPAIR_PROCEDURE, robotName);
    }

    @Override
    public String work(String robotName, int procedureTime) {
        nameValidator(robotName);
        this.work.doService(garage.getRobots().get(robotName), procedureTime);
        return String.format(WORK_PROCEDURE, robotName, procedureTime);
    }

    @Override
    public String charge(String robotName, int procedureTime) {
        nameValidator(robotName);
        this.charge.doService(garage.getRobots().get(robotName), procedureTime);
        return String.format(CHARGE_PROCEDURE, robotName);
    }

    @Override
    public String sell(String robotName, String ownerName) {
        nameValidator(robotName);
        this.garage.sell(robotName, ownerName);
        return String.format(SELL_ROBOT, ownerName, robotName);
    }

    @Override
    public String history(String procedureType) {
        StringBuilder sb = new StringBuilder();

        switch (procedureType) {
            case "Repair":
                sb.append(repair.history());
                break;
            case "Charge":
                sb.append(charge.history());
                break;
            case "Work":
                sb.append(work.history());
                break;
        }
        return sb.toString();
    }

    private void nameValidator(String name) {
        if(!garage.getRobots().containsKey(name)) {
            throw new IllegalArgumentException("Robot " + name + " does not exist");
        }
    }

}

package src.robotService.models.robots;

import src.robotService.models.robots.interfaces.Robot;

public abstract class BaseRobot implements Robot {
    private String name;
    private int happiness;
    private int energy;
    private int procedureTime;
    private String owner;
    private boolean isBought;
    private boolean isRepaired;

    public BaseRobot(String name, int energy, int happiness, int procedureTime) {
        this.name = name;
        setEnergy(energy);
        setHappiness(happiness);
        setProcedureTime(procedureTime);
        this.owner = "Service";
        this.isBought = false;
        this.isRepaired = false;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHappiness() {
        return this.happiness;
    }

    @Override
    public void setHappiness(int happiness) {
        if(happiness < 0 || happiness > 100) {
            throw new IllegalArgumentException("Invalid happiness");
        }
        this.happiness = happiness;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public void setEnergy(int energy) {
        if(energy < 0 || energy > 100) {
            throw new IllegalArgumentException("Invalid energy");
        }
        this.energy = energy;
    }

    @Override
    public int getProcedureTime() {
        return this.procedureTime;
    }

    @Override
    public void setProcedureTime(int procedureTime) {
        this.procedureTime = procedureTime;
    }

    @Override
    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public void setBought(boolean bought) {
        isBought = bought;
    }

    @Override
    public boolean isRepaired() {
        return this.isRepaired;
    }

    @Override
    public void setRepaired(boolean repaired) {
        isRepaired = repaired;
    }

    @Override
    public String toString() {
        return String.format(" Robot type: %s - %s - Happiness: %d - Energy: %d",
                this.getClass().getSimpleName(), getName(), getHappiness(), getEnergy());
    }
}

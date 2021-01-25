package command_pattern.skills;

public class Fireball implements ExecuteSkills {
    @Override
    public void execute() {
        System.out.println("Mage is casting FireBall.");
    }
}

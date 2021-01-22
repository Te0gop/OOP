package game_example.commands;

public class Defend implements Command {
    @Override
    public String execute() {
        return "game_example.commands.Defend activated. No points taken.";
    }

    @Override
    public void setCommandValue(Integer value) {
        throw new UnsupportedOperationException();
    }
}

package game_example.commands;

public class Move implements Command {
    private int meters;

    @Override
    public String execute() {
        return "Moved by " + meters + " meters";
    }

    @Override
    public void setCommandValue(Integer value) {
        this.meters = value;
    }
}

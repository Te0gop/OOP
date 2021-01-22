package game_example.commands;

public class Run implements Command {
    @Override
    public String execute() {
        return "Hero running...";
    }

    @Override
    public void setCommandValue(Integer value) {
        throw new UnsupportedOperationException();
    }
}

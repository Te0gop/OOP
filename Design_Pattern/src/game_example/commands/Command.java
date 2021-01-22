package game_example.commands;

public interface Command {
    String execute();
    void setCommandValue(Integer value);
}

package game_example.commands;

import game_example.utils.Main;

public class Lose implements Command {
    @Override
    public String execute() {
        Main.gameOver = true;
        return "You lost. Game over.";
    }

    @Override
    public void setCommandValue(Integer value) {

    }
}

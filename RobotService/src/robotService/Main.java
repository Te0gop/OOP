package src.robotService;

import src.robotService.core.EngineImpl;
import src.robotService.core.interfaces.Engine;

public class Main {
    public static void main(String[] args) {

        Engine engine = new EngineImpl();
        engine.run();

    }
}

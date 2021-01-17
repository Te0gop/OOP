package rpg_lab.mockito;

import java.util.concurrent.ThreadLocalRandom;

public class Time {
    public boolean isMorning() {
        return ThreadLocalRandom.current().nextInt(1000) % 7 == 0;
    }
}

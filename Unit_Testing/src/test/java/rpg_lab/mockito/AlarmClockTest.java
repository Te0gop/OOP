package rpg_lab.mockito;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.mockito.AlarmClock;
import rpg_lab.mockito.Time;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class AlarmClockTest {

    @Test
    public void testAlarmShouldBeOnInTheMorning() {
        while (true) {
            try {
                simulateTest();
                System.out.println("Passed");
            } catch (AssertionError err) {
                System.err.println(err.getMessage());
            }
        }
    }

    private void simulateTest() {
        Time time = Mockito.mock(Time.class);
        when(time.isMorning()).thenReturn(true);
        assertTrue(new AlarmClock(time).isAlarmOn());
    }

}
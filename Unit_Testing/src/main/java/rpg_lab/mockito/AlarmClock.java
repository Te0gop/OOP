package rpg_lab.mockito;

public class AlarmClock {
    private Time time;

    public AlarmClock(Time time) {
        this.time = time;
    }
    public boolean isAlarmOn() {
        return this.time.isMorning();
    }
}

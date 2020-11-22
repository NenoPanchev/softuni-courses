package p6_TirePressureMonitoringSystem;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlarmTest {
        Alarm alarm;
        Sensor sensor;

    @Test
    public void correctPressureShouldKeepAlarmOff() {
        sensor = mock(Sensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(17.);
        alarm = new Alarm(sensor);
        alarm.check();
        assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void pressureLowerThanSeventeenShouldTurnAlarmOn() {
        sensor = mock(Sensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(16.9);
        alarm = new Alarm(sensor);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void pressureHigherThanTwentyOneShouldTurnAlarmOn() {
        sensor = mock(Sensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(21.1);
        alarm = new Alarm(sensor);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }
}

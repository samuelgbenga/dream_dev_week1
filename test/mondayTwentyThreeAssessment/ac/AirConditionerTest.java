package mondayTwentyThreeAssessment.ac;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AirConditionerTest {

    AirConditioner ac = new AirConditioner();

    @Test
    void turnOnAC() {
        ac.turnOn();
        assertTrue(ac.isOn());
    }

    @Test
    void turnOffAC() {
        ac.turnOn();
        ac.turnOff();
        assertFalse(ac.isOn());
    }

    @Test
    void setTemperature() {
        ac.turnOn();
        ac.setTemperature(22);
        assertEquals(22, ac.getTemperature());
    }

    @Test
    void increaseTemperature() {
        ac.turnOn();
        ac.setTemperature(22);
        ac.increaseTemperature();
        assertEquals(23, ac.getTemperature());
    }

    @Test
    void decreaseTemperature() {
        ac.turnOn();
        ac.setTemperature(22);
        ac.decreaseTemperature();
        assertEquals(21, ac.getTemperature());
    }

    @Test
    void setFanSpeed() {
        ac.turnOn();
        ac.setFanSpeed(3);
        assertEquals(3, ac.getFanSpeed());
    }

    @Test
    void increaseFanSpeed() {
        ac.turnOn();
        ac.setFanSpeed(3);
        ac.increaseFanSpeed();
        assertEquals(4, ac.getFanSpeed());
    }

    @Test
    void decreaseFanSpeed() {
        ac.turnOn();
        ac.setFanSpeed(3);
        ac.decreaseFanSpeed();
        assertEquals(2, ac.getFanSpeed());
    }

    @Test
    void setMode() {
        ac.turnOn();
        ac.setMode("cool");
        assertEquals("cool", ac.getMode());
    }
}
package mondayTwentyThreeAssessment.television;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TelevisionTest {

    Television tv = new Television();

    @Test
    void turnOnTelevision() {
        tv.turnOn();
        assertTrue(tv.isOn());
    }

    @Test
    void turnOffTelevision() {
        tv.turnOn();
        tv.turnOff();
        assertFalse(tv.isOn());
    }

    @Test
    void increaseVolume() {
        tv.turnOn();
        tv.setVolume(10);
        tv.increaseVolume();
        assertEquals(11, tv.getVolume());
    }

    @Test
    void decreaseVolume() {
        tv.turnOn();
        tv.setVolume(10);
        tv.decreaseVolume();
        assertEquals(9, tv.getVolume());
    }

    @Test
    void nextChannel() {
        tv.turnOn();
        tv.setChannel(5);
        tv.nextChannel();
        assertEquals(6, tv.getChannel());
    }

    @Test
    void previousChannel() {
        tv.turnOn();
        tv.setChannel(5);
        tv.previousChannel();
        assertEquals(4, tv.getChannel());
    }

    @Test
    void cannotChangeChannelWhenOff() {
        tv.setChannel(5);
        assertEquals(0, tv.getChannel());
    }

    @Test
    void cannotIncreaseVolumeWhenOff() {
        tv.setVolume(10);
        tv.increaseVolume();
        assertEquals(10, tv.getVolume()); 
    }
}
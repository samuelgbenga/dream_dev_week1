package mondayTwentyThreeAssessment.bike;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BikeTest {


        Bike bike = new Bike();



    @Test
    void turnOnTheBike() {

        bike.setIsTurnedOnToOn();
        assertTrue(bike.getIsTurnedOn());
    }

    @Test
    void turnOffTheBike() {
        bike.setIsTurnedOnToOff();
        assertFalse(bike.getIsTurnedOn());
    }


    @Test
    void accelerateBikeSpeed(){
        bike.setSpeed(20);
        bike.accelerate();
        assertEquals(21, bike.getSpeed());
    }

    @Test
    void testThatTheGearChangeAfterAnIncreaseInSpeedRange(){

        bike.setSpeed(20);
        bike.accelerate();
        assertEquals(2, bike.getGear());
    }

    @Test
    void decelerateBikeSpeed(){
        bike.setSpeed(31);
        bike.decelerate();
        assertEquals(29, bike.getSpeed());
    }

    @Test
    void testThatTheGearChangeAfterAnDecreaseInSpeedRange(){

        bike.setSpeed(32);
        bike.accelerate();
        assertEquals(1, bike.getGear());
    }

    @Test
    void changeGear(){

    }
}

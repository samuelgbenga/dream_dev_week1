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
    void changeGear(){

    }
}

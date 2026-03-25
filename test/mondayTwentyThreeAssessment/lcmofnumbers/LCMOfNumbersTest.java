package mondayTwentyThreeAssessment.lcmofnumbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LCMOfNumbersTest {

    @Test
    void testTheInput(){
        assertArrayEquals(new int[]{1, 2, 3, 4}, LCMOfNumbers.takeInputArr(1,2,3,4));
    }

}
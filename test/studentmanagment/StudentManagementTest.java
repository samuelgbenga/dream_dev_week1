package studentmanagment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentManagementTest {

    @BeforeEach
    void setUp() {
        // reset global state
        StudentManagement.hardestSubject = 0;
        StudentManagement.easiestSubject = 0;
        StudentManagement.numberOfSuccess = Integer.MIN_VALUE;
        StudentManagement.numberOfFailures = Integer.MIN_VALUE;

        StudentManagement.highestOverallScore = Integer.MIN_VALUE;
        StudentManagement.lowestOverallScore = Integer.MAX_VALUE;

        StudentManagement.highestOverallStudent = null;
        StudentManagement.lowestOverallStudent = null;

        StudentManagement.bestGraduatingStudent = null;
        StudentManagement.worseGraduatingStudent = null;

        StudentManagement.sumOfTotalScores = 0;
        StudentManagement.sumOfAverageScores = 0;
    }



    @Test
    void testCalculateTotals() {
        int[][] scores = {
                {10, 20, 30},
                {40, 50, 60}
        };

        int[] result = StudentManagement.calculateTotals(scores);

        assertArrayEquals(new int[]{60, 150}, result);
    }

    @Test
    void testCalculateAverages() {
        int[][] scores = {
                {10, 20, 30},
                {40, 50, 60}
        };

        double[] result = StudentManagement.calculateAverages(scores);

        assertArrayEquals(new double[]{20.0, 50.0}, result);
    }

    @Test
    void testCalculatePositions() {
        int[] totals = {200, 300, 100};

        int[] result = StudentManagement.calculatePositions(totals);

        assertArrayEquals(new int[]{2, 1, 3}, result);
    }

    @Test
    void testTranspose() {
        int[][] original = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] result = StudentManagement.transpose(original);

        int[][] expected = {
                {1, 4},
                {2, 5},
                {3, 6}
        };

        assertArrayEquals(expected, result);
    }

    @Test
    void testPassAndFailTracking() {
        int[] subject1 = {30, 40, 45}; // all fail
        int[] subject2 = {60, 70, 80}; // all pass

        StudentManagement.getNumberOfFails(subject1, 1);
        StudentManagement.getNumberOfPasses(subject2, 2);

        assertEquals(1, StudentManagement.hardestSubject);
        assertEquals(3, StudentManagement.numberOfFailures);

        assertEquals(2, StudentManagement.easiestSubject);
        assertEquals(3, StudentManagement.numberOfSuccess);
    }

    @Test
    void testHighestAndLowestStudentTracking() {
        int[] scores = {10, 90, 50};

        String highest = StudentManagement.getHighestStudent(scores, 1);
        String lowest = StudentManagement.getLowestStudent(scores, 1);

        assertEquals("Student2", highest);
        assertEquals("Student1", lowest);

        assertEquals(90, StudentManagement.highestOverallScore);
        assertEquals("Student2", StudentManagement.highestOverallStudent);

        assertEquals(10, StudentManagement.lowestOverallScore);
        assertEquals("Student1", StudentManagement.lowestOverallStudent);
    }

    @Test
    void testBestAndWorstGraduatingStudent() {
        int[] totals = {200, 500, 100};

        int best = StudentManagement.getHighestTotalScore(totals);
        int worst = StudentManagement.getLowestTotalScore(totals);

        assertEquals(500, best);
        assertEquals("Student2", StudentManagement.bestGraduatingStudent);

        assertEquals(100, worst);
        assertEquals("Student3", StudentManagement.worseGraduatingStudent);
    }
}
package mondayTwentyThreeAssessment.personproblem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    private Person person;

    @BeforeEach
    public void setUp() {
        person = new Person("Samuel");
    }

    @Test
    public void testAddProblem() {
        Problem problem = new Problem("Network Issue", "Technical");

        person.addProblem(problem);

        assertEquals(1, person.getProblemList().size());
        assertTrue(person.getProblemList().contains(problem));
    }

    @Test
    public void testGetProblemList() {
        Problem problem1 = new Problem("Login Issue", "Technical");
        Problem problem2 = new Problem("Payment Issue", "Financial");

        person.addProblem(problem1);
        person.addProblem(problem2);

        assertEquals(2, person.getProblemList().size());
    }

    @Test
    public void testResolveProblem() {
        Problem problem = new Problem("Bug", "Technical");

        person.resolveProblem(problem);

        assertTrue(problem.isSolved);
    }

    @Test
    public void testProblemListInitiallyEmpty() {
        assertTrue(person.getProblemList().isEmpty());
    }
}
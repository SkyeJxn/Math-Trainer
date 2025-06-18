import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
chore: add maven support and convert tests to JUnit 5
/**
 * Testing the Calculator class before implementation.
 * @author SkyeJxn
 * @version 1.0
 */
public class CalculatorTest {
    /**
     * Entry point for testing.
     * Checks functionality of Calculator.
     * @param args command-line arguments (not used)
     */
    @Test
    public void testTaskFunctions() {
        //Object generation & default testing parameters
        Calculator test = new Calculator();
        int range = 10;
        int simIn = 3;
        int n = 10;
        int correct = 0; //counter for correct tasks

        //testing loop (n tasks)
        for (int i = 0; i < n; i++){
            //task generation
            String task = test.newTask(range);
            assertNotNull(task, "Generated task should not be null");

            //update of simulated input
            if(i%2 == 0){
                simIn = test.getRes();
            }

            boolean check = test.checkResult(simIn);

            //result check
            if (i % 2 == 0){
                assertTrue(check, "Should be correct");
                correct++;
            }
            else{
                assertFalse(check, "should be wrong, using last reult");
            }
        }

        assertEquals(n/2, correct, "Half the tasks should be correct");
    }
}

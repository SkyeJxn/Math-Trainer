import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    void testTaskFunctions() {
        //Object generation & default testing parameters
        Calculator test = new Calculator();
        int range = 10;
        int simIn;
        int n = 10;
        int correct = 0; //counter for correct tasks

        //testing loop (n tasks)
        for (int i = 0; i < n; i++){
            //task generation
            String task = test.newTask(range);
            assertNotNull(task, "Generated task should not be null");
            
            //result check
            if (i % 2 == 0){
                simIn = test.getRes();
                assertTrue(test.checkResult(simIn), "Should be correct");
                correct++;
            }
            else{
                simIn = test.getRes()*2;
                assertFalse(test.checkResult(simIn), "should be wrong, using last result");
            }
        }

        assertEquals(n/2, correct, "Half the tasks should be correct");
    }
}

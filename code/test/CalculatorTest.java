package code.test;
import code.Calculator;

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
    public static void main(String[] args) {
        //Object generation & default testing parameters
        Calculator test = new Calculator();
        int range = 10;
        int in = 3;
        int n = 10;

        //testing loop (n tasks)
        for (int i = 0; i < n; i++){
            //task generation
            String str = test.newTask(range);
            System.out.println(str);

            //update of simulated input
            if(i%2 == 0){
                in = test.getRes();
            }
            System.out.println("Simulated input: " + in);

            //result check
            if (test.checkResult(in)){
                System.out.println("Correct");
            }
            else{
                System.out.println("Wrong");
            }
        }
    }
}

package core;
import java.util.Random;
/**
 * Generates random math tasks (addition, subtraction, multiplication, division),
 * calculates the results and returns formatted task Strings.
 * @author SkyeJxn
 * @version 1.0
 */
public class Calculator {
    private final Random rand;
    private int a;
    private int b;
    private int op;
    private int res;
    private String task;

    /**
     * Standard constructor.
     */
    public Calculator(){
        rand = new Random();
        a = 0;
        b = 0;
        op = 0;
        res = 0;
        task = "";
    }

    /**
     * Generates new, random math tasks.
     * @param range number upper bound (exclusive) for operand values
     * @return a formatted math task string
     */
    public String newTask(int range){
        a = rand.nextInt(range);
        b = rand.nextInt(range);
        op = rand.nextInt(4);

        switch (op) { //operator switch
            case 0 -> task = addition();
            case 1 -> task = subtraction();
            case 2 -> task = multiplication();
            case 3 -> task = division();
            default -> System.out.println("Error: unknown operator!");
        }

        return task;
    }

    /**
     * Returns the correct result of the most recently generated task.
     */
    public int getRes(){
        return res;
    }

    private String addition(){
        res = a + b;
        return a + " + " + b + " = ";
    }

    private String subtraction(){
        res = a - b;
        return a + " - " + b + " = ";
    }

    private String multiplication(){
        res = a * b;
        return a + " * " + b + " = ";
    }

    private String division(){
        if (b == 0) b = 1; // no dividing by 0
        res = a / b;
        a = res * b;
        return a + " / " + b + " = ";
    }

    /**
     * Checks if input equals the calculated result.
     * @param in input value to check
     * @return true if input equals result
     */
    public boolean checkResult(int in){
        return in == res;
    }
}
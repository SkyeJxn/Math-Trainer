package core;
/**
 * Implementation of the RunTimer feature.
 * @author SkyeJxn
 * @version 1.0
 */
public class RunTimer{

    private long start;
    private double runtime;

    /**
     * Standard constructor.
     */
    public RunTimer(){
        start = 0;
        runtime = 0;
    }

    /**
     * Starts the task timer.
     */
    public void start(){
        start = System.nanoTime();
    }

    /**
     * Stops the task timer and prints the needed time in seconds.
     * @param message type of timer to print
     */
    public String end(String message){
        runtime = (System.nanoTime() - start)/1000000000.0;
        String out = String.format("That %s took %.2f seconds", message, runtime);
        return out;
    }
}

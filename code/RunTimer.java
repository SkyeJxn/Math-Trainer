package code;

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
     */
    public void end(String message){
        runtime = (System.nanoTime() - start)/1000000000.0;
        System.out.println("That " + message + " took " + runtime + " seconds.");
    }
}

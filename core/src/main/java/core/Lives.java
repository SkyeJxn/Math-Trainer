package core;
/**
 * Implementation of the Lives feature.
 * @author SkyeJxn
 * @version 1.0
 */
public class Lives{
    private int max;
    private int current;

    /**
     * Standard constructor.
     * @param x number of starting lives.
     */
    public Lives(int x){
        max = x;
        current = x;
    }

    /**
     * Returns the max number of lives.
     */
    public int getMax(){
        return max;
    }

    /**
     * Returns the current number of lives.
     */
    public int getCurrent(){
        return current;
    }

    /**
     * Changes the number of remaining lives by x.
     * @param x value added to current lives.
     */
    public void changeCurrent(int x){
        current = current + x;
        if (current > max) current = max;
    }
    /**
     * Resets the current number of lives to the max value.
     */
    public void resetCurrent(){
        current = max;
    }

    /**
     * Changes the max value of lives.
     * @param numMax new max number of lives.
     */
    public void setMax(int numMax){
        max = numMax;
        current = max;
    }

    /**
     * Returns if the current number of lives is above 0.
     */
    public boolean alive(){
        return current > 0;
    }

    /**
     * Returns a formatted string containing current lives.
     * Returns a ending message if current lives are 0.
     */
    @Override
    public String toString(){
        String out;
        if (current > 0){
            out = String.format("Lives left: %d", current);
        }
        else{
            out = "No lives left.";
        }
        return out;
    }
}
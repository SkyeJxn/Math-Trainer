package code;
/**
 * Controls which features are activated in the game.
 * Stores configuration settings for the game (feature toggles, task number, operand range).
 * @author SkyeJxn
 * @version 1.0
 */
public class Config {
    private int tasks;
    private int range;
    private boolean useLives;
    private boolean useTimer;

    /**
     * Standard constructor.
     */
    public Config(){
        tasks = 5;
        range = 10;
        useTimer = false;
        useLives = false;
        }

    /**
     * Sets the number of tasks per round.
     */
    public void setTasks(int numTasks){
        tasks = numTasks;
    }

    /**
     * Sets the upper limit (exclusive) for the operands of the tasks.
     */
    public void setRange(int numRange){
        range = numRange;
    }

    /**
     * Activates / deactivates the Lives Feature
     */
    public void setLives(boolean stateLives){
        useLives = stateLives;
    }

    /**
     * Activates / deactivates the RunTimer Feature
     */
    public void setTimer(boolean stateTimer){
        useTimer = stateTimer;
    }

    /**
     * Returns the current number of tasks per round.
     */
    public int getTasks(){
        return tasks;
    }

    /**
     * Returns the current upper limit of the operands.
     */
    public int getRange(){
        return range;
    }

    /**
     * Returns if the Lives feature is activated.
     */
    public boolean getLives(){
        return useLives;
    }

    /**
     * Returns if the RunTimer feature is activated.
     */
    public boolean getTimer(){
        return useTimer;
    }
}

package code;

/**
 * Implementation of the Statistics feature.
 * @author SkyeJxn
 * @version 1.0
 */
public class Statistics {
    private int rightCount;
    private int wrongCount;

    /**
     * Standard constructor.
     */
    public Statistics(){
        rightCount = 0;
        wrongCount = 0;
    }

    /**
     * Adds a new data point to the statistic.
     * @param res true if result was correct, otherwise false.
     */
    public void addCount(boolean res){
        if(res){
            rightCount++;
        }
        else{
            wrongCount++;
        }
    }

    /**
     * Returns the number of tasks answered right.
     */
    public int getRightCount() {
        return rightCount;
    }

    /**
     * Returns the number of tasks answered wrong.
     */
    public int getWrongCount() {
        return wrongCount;
    }

    /**
     * Resets the Statistic to 0;
     */
    public void reset(){
        rightCount = 0;
        wrongCount = 0;
    }

    /**
     * Returns a string representation of this object.
     */
    @Override
    public String toString(){
        String nl = System.lineSeparator();
        int complete = rightCount + wrongCount;
        String output = "Stats:" + nl +
        "Questions: " + complete + nl +
        "Right: " + rightCount + nl +
        "Wrong: " + wrongCount;

        return output;
    }
}

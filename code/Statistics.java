package code;

public class Statistics {
    private int rightCount;
    private int wrongCount;

    public Statistics(){
        rightCount = 0;
        wrongCount = 0;
    }

    public void addCount(boolean res){
        if(res){
            rightCount++;
        }
        else{
            wrongCount++;
        }
    }

    public int getRightCount() {
        return rightCount;
    }

    public int getWrongCount() {
        return wrongCount;
    }

    public void reset(){
        rightCount = 0;
        wrongCount = 0;
    }

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

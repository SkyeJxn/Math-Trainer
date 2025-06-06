package code;

public class Config {
    private int tasks;
    private int range;
    private boolean useLives;
    private boolean useTimer;

    public Config(){
        tasks = 3;
        range = 10;
        useTimer = false;
        useLives = false;
        }

    public void setTasks(int numRounds){
        tasks = numRounds;
    }

    public void setRange(int numRange){
        range = numRange;
    }

    public void setLives(boolean stateLives){
        useLives = stateLives;
    }

    public void setTimer(boolean stateTimer){
        useTimer = stateTimer;
    }

    public int getTasks(){
        return tasks;
    }

    public int getRange(){
        return range;
    }

    public boolean getLives(){
        return useLives;
    }

    public boolean getTimer(){
        return useTimer;
    }

}

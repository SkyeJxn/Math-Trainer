public class Config {
    private int rounds;
    private int range;
    private boolean useLives;
    private boolean useTimer;

    public Config(){
        rounds = 5;
        range = 50;
        useTimer = false;
        useLives = false;
        }

    public void setRounds(int numRounds){
        rounds = numRounds;
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

    public int getRounds() {
        return rounds;
    }

    public int getRange() {
        return range;
    }

    public boolean getLives(){
        return useLives;
    }

    public boolean getTimer(){
        return useTimer;
    }

}

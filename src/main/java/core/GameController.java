package core;

/**
 * Controls the game logic and flow.
 * Connects all core components.
 * @author SkyeJxn
 * @version 1.0
 */
public class GameController {
    private final Calculator calc;
    private final Config conf;
    private final RunTimer rt;
    private final RunTimer tt;
    private final Lives lives;
    private final Statistics stats;
    private boolean living;

    /**
     * Standard constructor.
     */
    public GameController(){
        calc = new Calculator();
        conf = new Config();
        rt = new RunTimer(); //round timer
        tt = new RunTimer(); //task timer
        lives = new Lives(3);
        stats = new Statistics();
        living = true;
    }

    /**
     * Changes the saved configuration.
     * Checks validity of configured parameters.
     * @param useLive activate/deactivate the Lives feature.
     * @param useTaskTime activate/deactivate the Task Timer feature.
     * @param useRoundTime activate/deactivate the Round Timer feature.
     * @param numTasks number of tasks per round.
     * @param numRange upper bound for operands.
     * @param numLives number of max lives.
     */
    public void changeConfig(boolean useLive, boolean useTaskTime, boolean useRoundTime, int numTasks, int numRange, int numLives){
        // error for invalid input
        String err = "no number smaller than 1 allowed. Changed to default";

        // change state of Features
        conf.setLives(useLive);
        conf.setTaskTimer(useTaskTime);
        conf.setRoundTimer(useRoundTime);

        // validate task input & change task number
        if (numTasks < 1){
            System.out.println(err);
            numTasks = 5; //default number of tasks
        }

        // validate range input & change operand range
        conf.setTasks(numTasks);
        if (numRange < 1){
            System.out.println(err);
            numRange = 10; //default range
        }
        conf.setRange(numRange);

        lives.setMax(numLives);

        stats.reset();
    }

    /**
     * Generates new math task and starts timer (if active).
     */
    public void newTask(){
        System.out.println(calc.newTask(conf.getRange()));

        //timer start (if active)
        if (conf.getTaskTimer()){
                tt.start();
        }
    }

    /**
     * Compares input to calculated result, prints result strings.
     * Influences current lives and stops timer (if active).
     * @param in input value to compare to calculated result.
     */
    public String checkTask(int in){
        boolean res = calc.checkResult(in);

        String s1;
        String s2 = "";
        String s3 = "";

        // output request
        if (res){
            s1 = String.format("Correct. %s%n", GamePrints.Motivator());
        }
        else {
            s1 = String.format("Wrong. %s%n", GamePrints.Encourager());
            if (conf.getLives()){
                lives.changeCurrent(-1);
                living = lives.alive();
                if (living) s2 = String.format("%d from %d lives left. %n",lives.getCurrent(), lives.getMax());
            }
        }

        // Timer stop (if active)
        if (conf.getTaskTimer()){
            s3 = tt.end("Task");
        }
        stats.addCount(res);

        return String.format("%s%s%s%n", s1, s2, s3);
    }

    /**
     * Returns if the game is still active (relevant for Lives feature).
     */
    public boolean getLiving(){
        return living;
    }

    /**
     * Starts the Round Timer (if active)
     */
    public void startRoundTime(){
        if (conf.getRoundTimer()){
            rt.start();
        }
    }


    /**
     * Stops the Round Timer (if active)
     */
    public String endRoundTime(){
        String out = "";
        if (conf.getRoundTimer()){
            out = rt.end("Round");
        }
        return out;
    }

    /**
     * Returns number of tasks per round.
     */
    public int getLength(){
        return conf.getTasks();
    }

    /**
     * Prints round statistics and remaining lives (if active).
     */
    public String gameEnding(){
        return String.format("%s",stats);
    }

    /**
     * adds one live for the next round (if Lives feature is active).
     * @param num number of added lives after
     */
    public String newRound(int num){
        lives.changeCurrent(num);
        String out = String.format("You survived a round and gained %d live%n", num);
        if (num > 1) System.out.print("s");
        return out;
    }

    /**
     * returns the activation state of the lives function
     */
    public boolean getLiveUse(){
        return conf.getLives();
    }
}
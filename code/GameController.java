package code;

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
    private final Lives lives;
    private final Statistics stats;
    private boolean living;

    /**
     * Standard constructor.
     */
    public GameController(){
        calc = new Calculator();
        conf = new Config();
        rt = new RunTimer();
        lives = new Lives(3);
        stats = new Statistics();
        living = true;
    }

    /**
     * Changes the saved configuration.
     * Checks validity of configured parameters.
     * @param useLive activate/deactivate the Lives feature.
     * @param useTime activate/deactivate the RunTimer feature.
     * @param numTasks number of tasks per round.
     * @param numRange upper bound for operands.
     * @param numLives number of max lives.
     */
    public void changeConfig(boolean useLive, boolean useTime, int numTasks, int numRange, int numLives){
        // error for invalid input
        String err = "no number smaller than 1 allowed. Changed to default";

        // change state of Features
        conf.setLives(useLive);
        conf.setTimer(useTime);

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
        if (conf.getTimer()){
                rt.start();
        }
    }

    /**
     * Compares input to calculated result, prints result strings.
     * Influences current lives and stops timer (if active).
     * @param in input value to compare to calculated result.
     */
    public void checkTask(int in){
        boolean res = calc.checkResult(in);

        // output request
        if (res){
            System.out.println("Correct. " + GamePrints.Motivator() + System.lineSeparator());
        }
        else {
            System.out.println("Wrong. " + GamePrints.Encourager() + System.lineSeparator());
            if (conf.getLives()){
                lives.changeCurrent(-1);
                living = lives.alive();
                if (living) System.out.println(lives.getCurrent() + " from " + lives.getMax() + " lives left." + System.lineSeparator());
            }
        }

        // Timer stop (if active)
        if (conf.getTimer()){
            rt.end();
        }
        stats.addCount(res);
    }

    /**
     * Returns if the game is still active (relevant for Lives feature).
     */
    public boolean getLiving(){
        return living;
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
    public void gameEnding(){
        System.out.println(stats);
    }

    /**
     * adds one live for the next round (if Lives feature is active).
     * @param num number of added lives after
     */
    public void newRound(int num){
        lives.changeCurrent(num);
        System.out.println("You survived a round and gained " + num + " live");
        if (num > 1) System.out.print("s");
    }

    public boolean getLiveUse(){
        return conf.getLives();
    }
}
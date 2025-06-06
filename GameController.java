public class GameController {
    private final Calculator calc;
    private final Config conf;
    private final RunTimer rt;
    private final Lives lives;
    private final Statistics stats;
    private boolean living;

    public GameController(){
        calc = new Calculator();
        conf = new Config();
        rt = new RunTimer();
        lives = new Lives(3);
        stats = new Statistics();
        living = true;
    }

    public void changeConfig(boolean useLive, boolean useTime, int numRounds, int numRange){
        String err = "no number smaller than 1 allowed. Changed to default";
        conf.setLives(useLive);
        conf.setTimer(useTime);
        if (numRounds < 1){
            System.out.println(err);
            numRounds = 5;
        }
        conf.setTasks(numRounds);
        if (numRange < 1){
            System.out.println(err);
            numRange = 10;
        }
        conf.setRange(numRange);
    }

    public void newTask(){
        System.out.println(calc.newTask(conf.getRange()));
            if (conf.getTimer()){
                rt.start();
            }
    }

    public void checkTask(int in){
        boolean res = calc.checkresult(in);
        if (res){
            System.out.println("Correct. " + GamePrints.Motivator());
        }
        else {
            System.out.println("Wrong. " + GamePrints.Encourager());
            if (conf.getLives()){
                lives.changeCurrent(-1);
                living = lives.alive();
                if (living) System.out.println(lives.getCurrent() + " from " + lives.getMax() + " lives left.");
            }
        }
        if (conf.getTimer()){
            rt.end();
        }
        stats.addCount(res);
    }

    public boolean getLiving(){
        return living;
    }

    public int getLength(){
        return conf.getTasks();
    }

    public void endRound(){
        System.out.println(stats);
        if (conf.getLives()) System.out.println(lives);
    }

    public void newRound(){
        if (conf.getLives()) lives.changeCurrent(1);
    }
}
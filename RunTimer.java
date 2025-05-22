public class RunTimer extends Mechanic{

    private long start;
    private long runtime;

    public RunTimer(){
        super();
        start = 0;
        runtime = 0;
    }

    public void start(){
        start = System.nanoTime();
    }

    public void end(){
        runtime = System.nanoTime() - start;
        System.out.println("That took " + runtime + " seconds.");
    }
}

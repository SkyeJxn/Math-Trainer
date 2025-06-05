public class RunTimer{

    private long start;
    private long runtime;

    public RunTimer(){
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

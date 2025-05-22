
import java.util.Scanner;

public class Lives extends Mechanic {

    private int max;
    private int current;
    private Scanner scanner;

    public Lives(int x){
        super();
        max = x;
        current = x;
    }

    public int getMax(){
        return max;
    }

    public int getCurrent(){
        return current;
    }

    public void changeCurrent(int x){
        current = current + x;
    }

    public void resetCurrent(){
        current = max;
    }

    public void setMax(){
        System.out.println("Setting Stock Count.");
        System.out.println("How many Lives do you want to have?: ");
        max = scanner.nextInt();
        System.out.println("");
    }
}

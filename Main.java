
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Config sim = new Config();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        String in = "";

        sim.changeGamemode();
        sim.changeRange();
        sim.changeRounds();

        while (run == true){
            sim.Game();
            System.out.println("want to continue? (Y/N):");
            in = scanner.nextLine();

            if (in.equalsIgnoreCase("Y")){
                run = true;
            }
            if (in.equalsIgnoreCase("N")){
                run = false;
            }
        }
    }
}

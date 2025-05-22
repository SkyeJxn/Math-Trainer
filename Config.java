
import java.util.Scanner;

public class Config {
    
    private int Gamemode;
    private final Calculator calc;
    private final Lives stocked;
    private final RunTimer timing;
    private int Rounds;
    private Scanner scanner;
    private int range;

    public Config(){
        calc = new Calculator();
        Gamemode = 3;
        scanner = new Scanner(System.in);
        stocked = new Lives(3);
        timing = new RunTimer();
        Rounds = 5;
        range = 50;
        }

    public void changeGamemode(){
        System.out.println("Gamemodes: 1 = Stocked; 2 = Timed; 3 = Free");
        System.out.println("Which gamemode do you want?:");
        Gamemode = scanner.nextInt();

        if (Gamemode == 1){
            stocked.setMax();
        }

        System.out.println("");
    }

    public void changeRounds(){
        System.out.println("Changing Round Count");
        System.out.println("How many rounds do you want to play?:");
        Rounds = scanner.nextInt();
    }

    public void changeRange(){
        System.out.println("Changing calculator range");
        System.out.println("What range should the questions have?:");
        range = scanner.nextInt();
    }

    public String getGamemode(){
        String mode = "";

        switch(Gamemode){
            case 1: 
                mode = "Stocked";
                break;
            case 2:
                mode = "Timed";
                break;
            case 3:
                mode = "free";
        }

        return mode;
    }

    public void Game(){
        for (int i = 0; i < Rounds; i++) {
            if (Gamemode == 2){
                timing.start();
            }
            calc.newRound(range);
            if (Gamemode == 2){
                timing.end();
            }
        }
    }
}

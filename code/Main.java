package code;
import java.util.Scanner;

/**
 * Entry point of the program.
 * Initializes the game and handles the game loop.
 * @author SkyeJxn
 * @version 1.0
 */
public class Main {
    @SuppressWarnings("ConvertToTryWithResources")

    /**
     * Starts the game loop and handles user inputs.
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Object generation & runtime parameters
        GameController controller = new GameController();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        int in;
        String ln = System.lineSeparator();

        // Title print
        GamePrints.printBox(" MATH TRAINER ");

        // Game loop
        while(run == true){

            // Single round loop
            for (int i = 0; i < controller.getLength(); i++) {
                controller.newTask();
                in = scanner.nextInt();
                controller.checkTask(in);
                if (controller.getLiving() == false) break;
            }

            controller.endRound();

            // next round prompt
            System.out.println(ln + "Want to continue?(Y/N): ");
            if (scanner.next().equalsIgnoreCase("y")){
                controller.newRound();
            }
            else{
                GamePrints.printBox(" GOODBYE! ");
                run = false;
            }
        }
        scanner.close();
    }
}
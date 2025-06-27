package terminal;
import java.util.Scanner;

import core.GameController;
import core.GamePrints;
@SuppressWarnings("ConvertToTryWithResources")

/**
 * Entry point of the program.
 * Initializes the game and handles the game loop.
 * @author SkyeJxn
 * @version 1.0
 */
public class MainTerminal {
    /**
     * Starts the game loop and handles user inputs.
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Object generation & runtime parameters
        GameController controller = new GameController();
        Scanner scanner = new Scanner(System.in);
        int in;
        boolean newGame = true;
        boolean cont;
        
        // Title print
        System.out.println(GamePrints.printBox(" MATH TRAINER "));
        
        // Game loop
        while(true){
            if (newGame){
                //Config Prompt before each new round
                if (PromptYN(scanner, "Want to change the Config?: ")){
                    System.out.println("\nPress enter to leave Defaults. \n");
                    configPrompt(controller, scanner);
                }
                newGame = false;
            }

            // Single round loop
            for (int i = 0; i < controller.getLength(); i++) {
                if (i==0) controller.startRoundTime();
                System.out.println(controller.newTask());
                in = taskAnswer(scanner);
                System.out.println(controller.checkTask(in));
                if (controller.getLiving() == false) break;
            }
            System.out.println(controller.endRoundTime());

            // next round prompt
            if (controller.getLiveUse() && !controller.getLiving()){
                System.out.println("No lives left \n");
                cont = false;
            }
            else if (controller.getLiveUse()) {
            cont = true;
            System.out.println(controller.newRound(1));
            }
            else{
                cont = PromptYN(scanner, "Want to continue?: ");
            }
            
            if (!cont){
                System.out.println(controller.gameEnding());
                newGame = PromptYN(scanner, "Want to start a new game?: ");
            }

            if (!cont && !newGame){
                System.out.println(GamePrints.printBox(" GOODBYE "));
                break;
            }
            
        }
        scanner.close();
    }

    private static boolean PromptYN(Scanner scanner, String message){
        System.out.printf("%s (Y/N)", message);
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("y");
    }

    private static int taskAnswer(Scanner scanner){
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    private static int intPrompt(Scanner scanner, String message, int defaultValue){
        System.out.printf("%s (default: %d)%n", message, defaultValue);
        try{
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.printf("Invalid input. Using default value: %d %n", defaultValue);
            return defaultValue;
        }
    }

    private static void configPrompt(GameController controller, Scanner scanner){
        System.out.println(GamePrints.printBox(" CONFIGURATION "));

        int range = intPrompt(scanner, "Enter max operand range: ", 10);
        int tasks = intPrompt(scanner, "Enter number of tasks per round: ", 5);
        boolean useTaskTimer = PromptYN(scanner, "Use task timer?: ");
        boolean useRoundTimer = PromptYN(scanner, "Use round timer?: ");
        boolean useLives = PromptYN(scanner, "Use Lives?: ");
        int lives = 3;
        if (useLives){
            lives = intPrompt(scanner, "Enter number of lives: ", 3);
        }

        controller.changeConfig(useLives, useTaskTimer, useRoundTimer, tasks, range, lives);

        System.out.println(GamePrints.printBox(" CHANGED CONFIGURATION "));
    }
}
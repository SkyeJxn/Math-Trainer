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
        boolean cont = true;

        // Title print
        GamePrints.printBox(" MATH TRAINER ");

        // Game loop
        while(run == true){

            //Config Prompt before each new round
            if (PromptYN(scanner, "Want to change the Config? (Warning, This resets the Statistics): ")){
                System.out.println("\n Press enter to leave Defaults. \n");
                configPrompt(controller, scanner);
            }

            // Single round loop
            for (int i = 0; i < controller.getLength(); i++) {
                controller.newTask();
                in = taskAnswer(scanner);
                controller.checkTask(in);
                if (controller.getLiving() == false) break;
            }
            
            // next round prompt
            if (controller.getLiveUse() && controller.getLiving()){
                controller.roundEnding(true);
            } else{
                if (controller.getLiveUse()) System.out.println("No lives left \n");
                cont = PromptYN(scanner, "Want to continue?: ");
                controller.roundEnding(cont);
            }

            if (!cont) run = false;
        }
        scanner.close();
    }

    private static boolean PromptYN(Scanner scanner, String message){
        System.out.println(message + "(Y/N)");
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
        System.out.println(message + "(default value " + defaultValue + ")");
        try{
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Using default value: " + defaultValue);
            return defaultValue;
        }
    }

    private static void configPrompt(GameController controller, Scanner scanner){
        GamePrints.printBox(" CONFIGURATION ");

        int range = intPrompt(scanner, "Enter max operand range: ", 10);
        int tasks = intPrompt(scanner, "Enter number of tasks per round: ", 5);
        boolean useTimer = PromptYN(scanner, "Use timer?: ");
        boolean useLives = PromptYN(scanner, "Use Lives?: ");
        int lives = 3;
        if (useLives){
            lives = intPrompt(scanner, "Enter number of lives: ", 3);
        }

        controller.changeConfig(useLives, useTimer, tasks, range, lives);

        GamePrints.printBox(" CHANGED CONFIGURATION ");
    }
}
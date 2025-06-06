import java.util.Scanner;

public class Main {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        GameController controller = new GameController();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        int in;
        String ln = System.lineSeparator();

        GamePrints.printBrackets(" MATH TRAINER ");

        while(run == true){
            for (int i = 0; i < controller.getLength(); i++) {
                controller.newTask();
                in = scanner.nextInt();
                controller.checkTask(in);
                if (controller.getLiving() == false) break;
            }
            controller.endRound();
            System.out.println(ln + "Want to continue?(Y/N): ");
            if (scanner.next().equalsIgnoreCase("y")){
                controller.newRound();
            }
            else{
                GamePrints.printBrackets(" GOODBYE! ");
                run = false;
            }
        }
        scanner.close();
    }
}

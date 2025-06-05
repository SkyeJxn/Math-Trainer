
import java.util.Random;
import java.util.Scanner;

public class Calculator {
    private final Random rand;
    private int a;
    private int b;
    private int op;
    private int res;
    private final Scanner scanner;
    private int ein;

    private static int right;
    private static int wrong;

    public Calculator(){
        scanner = new Scanner(System.in);
        rand = new Random();
        a = 0;
        b = 0;
        op = 0;
        res = 0;
        ein = 0;
    }

    public void newRound(int range){
        a = rand.nextInt(range);
        b = rand.nextInt(range);
        op = rand.nextInt(4);

        switch (op) {
            case 1 -> addition(a, b);
            case 2 -> subtraction(a, b);
            case 3 -> multiplication(a, b);
            case 4 -> division(a,b);
        }

        ein = scanner.nextInt();

        checkresult(ein);
    }

    private void addition(int o1, int o2){
        res = o1 + o2;
        System.out.println(o1 + " + " + o2 + " = ");
    }

    private void subtraction(int o1, int o2){
        res = o1 - o2;
        System.out.println(o1 + " - " + o2 + " = ");
    }

    private void multiplication(int o1, int o2){
        res = o1 * o2;
        System.out.println(o1 + " * " + o2 + " = ");
    }

    private void division(int o1, int o2){
        res = o1 / o2;
        System.out.println(o1 + " / " + o2 + " = ");
    }

    public int getRight(){
        return right;
    }

    public int getWrong(){
        return wrong;
    }

    private void changeRight(int x){
        right = right + x;
    }

    private void changeWrong(int x){
        wrong = wrong + x;
    }

    private void checkresult(int ein){
        if (ein == res){
            changeRight(1);
            System.out.println("Das ist Korrekt!");
        }
        else{
            changeWrong(1);
            System.err.println("Das ist Falsch! Das korrekte Ergebins ist " + res + ".");
        }
    }
}
import java.util.Random;

public class Calculator {
    private final Random rand;
    private int a;
    private int b;
    private int op;
    private int res;

    public Calculator(){
        rand = new Random();
        a = 0;
        b = 0;
        op = 0;
        res = 0;
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
    }

    public int getRes(){
        return res;
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

    public void checkresult(int ein){
        if (ein == res){
            System.out.println("Das ist Korrekt!");
        }
        else{
            System.err.println("Das ist Falsch! Das korrekte Ergebnis ist " + res + "!");
        }
    }
}
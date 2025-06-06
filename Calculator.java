import java.util.Random;

public class Calculator {
    private final Random rand;
    private int a;
    private int b;
    private int op;
    private int res;
    private String task;

    public Calculator(){
        rand = new Random();
        a = 0;
        b = 0;
        op = 0;
        res = 0;
        task = "";
    }

    public String newTask(int range){
        a = rand.nextInt(range);
        b = rand.nextInt(range);
        op = rand.nextInt(4);

        switch (op) {
            case 0 -> task = addition();
            case 1 -> task = subtraction();
            case 2 -> task = multiplication();
            case 3 -> task = division();
            default -> System.out.println("Error: unknown operator!");
        }

        return task;
    }

    public int getRes(){
        return res;
    }

    private String addition(){
        res = a + b;
        return a + " + " + b + " = ";
    }

    private String subtraction(){
        res = a - b;
        return a + " - " + b + " = ";
    }

    private String multiplication(){
        res = a * b;
        return a + " * " + b + " = ";
    }

    private String division(){
        if (b == 0) b = 1;
        res = a / b;
        a = res * b;
        return a + " / " + b + " = ";
    }

    public boolean checkresult(int ein){
        return ein == res;
    }
}
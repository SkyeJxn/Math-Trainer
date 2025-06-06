

public class Main {
    public static void main(String[] args) {
        Calculator test = new Calculator();
        int range = 10;
        int in = 3;

        for (int i = 0; i < 10; i++) {
            test.newRound(range);
            if(i%2 == 0){
                in = test.getRes();
            }
            System.out.println("Simulierte Eingabe: " + in);
            test.checkresult(in);
        }
    }
}

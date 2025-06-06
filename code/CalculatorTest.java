package code;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator test = new Calculator();
        int range = 10;
        int in = 3;

        for (int i = 0; i < 10; i++){
            String str = test.newTask(range);
            System.out.println(str);
            if(i%2 == 0){
                in = test.getRes();
            }
            System.out.println("Simulierte Eingabe: " + in);
            if (test.checkresult(in)){
                System.out.println("Correct");
            }
            else{
                System.out.println("Wrong");
            }
        }
    }
}

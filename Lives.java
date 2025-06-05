public class Lives{

    private int max;
    private int current;

    public Lives(int x){
        max = x;
        current = x;
    }

    public int getMax(){
        return max;
    }

    public int getCurrent(){
        return current;
    }

    public void changeCurrent(int x){
        current = current + x;
    }

    public void resetCurrent(){
        current = max;
    }

    public void setMax(int numMax){
        max = numMax;
    }
}

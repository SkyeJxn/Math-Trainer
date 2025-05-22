public class Mechanic{
    private boolean state;

    public Mechanic(){
        state = true;
    }

    public boolean getState(){
        return state;
    }

    public void setState(boolean newState){
        state = newState;
    }
}
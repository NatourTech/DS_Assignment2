public class MyStack extends Stack {
    private int popCounter = 0;
    private int pushCounter = 0;

    public void push(Object value){
        pushCounter++;
        super.push(value);
    }

    public Object pop(){
        popCounter++;
        return super.pop();
    }

    public int getPopCounter() {
        return popCounter;
    }

    public int getPushCounter() {
        return pushCounter;
    }
}

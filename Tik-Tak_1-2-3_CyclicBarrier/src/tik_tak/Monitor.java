package tik_tak;

public class Monitor {
    private int counter = 1;

    public void increaseCounter() {
        counter++;
    }

    public void resetCounter() {
        counter = 1;
    }

    public int getCounter() {
        return counter;
    }
}

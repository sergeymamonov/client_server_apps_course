package tik_tak;

public class Monitor {
    private int tikCounter = 1;
    private int lineCounter = 0;

    public int getTikCounter() {
        return tikCounter;
    }

    public void increaseTikCounter() {
        tikCounter++;
    }

    public boolean hasTikCounter() {
        return tikCounter <= AppMonitor.TIK_QUANTITY;
    }

    public void resetTikCounter() {
        tikCounter = 1;
    }

    public int getLineCounter() {
        return lineCounter;
    }

    public void increaseLineCounter() {
        lineCounter++;
    }
}

package tik_tak;

public class TikLine implements Runnable {
private static int lineQuantity = 0;

    @Override
    public void run() {
        try {
            Thread.sleep(500);
            System.out.print("\n");
            Tik.monitor.resetCounter();
            lineQuantity++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean hasNewLine() {
        return lineQuantity < App.LINE_QUANTITY;
    }
}

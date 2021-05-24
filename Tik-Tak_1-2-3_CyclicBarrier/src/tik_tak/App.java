package tik_tak;

import java.util.concurrent.CyclicBarrier;

public class App {
    public static final int TIK_QUANTITY = 3;
    public static final int LINE_QUANTITY = 5;
    public static final CyclicBarrier BARRIER = new CyclicBarrier(TIK_QUANTITY, new TikLine());

    public static void main(String[] args) {
        for (int i = 1; i <= TIK_QUANTITY; i++) {
            new Thread(new Tik(i)).start();
        }
    }
}

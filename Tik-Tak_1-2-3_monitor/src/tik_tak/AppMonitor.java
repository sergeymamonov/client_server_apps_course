package tik_tak;

public class AppMonitor {
    public static final int TIK_QUANTITY = 3;
    public static final int LINE_QUANTITY = 5;

    public static void main(String[] args) {
        for (int i = 1; i <= TIK_QUANTITY; i++) {
            new Thread(new Tik(i)).start();
        }
    }
}

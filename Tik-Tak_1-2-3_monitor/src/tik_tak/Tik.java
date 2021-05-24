package tik_tak;

public class Tik implements Runnable {
    private final int number;
    private static final Monitor monitor = new Monitor();

    public Tik(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (monitor) {
                if (Tik.monitor.getLineCounter() < AppMonitor.LINE_QUANTITY) {
                    if (number == Tik.monitor.getTikCounter()) {
                        System.out.print(number + " ");
                        Tik.monitor.increaseTikCounter();

                        if (Tik.monitor.hasTikCounter()) {
                            continue;
                        } else {
                            System.out.print("\n");
                            Tik.monitor.resetTikCounter();
                            Tik.monitor.increaseLineCounter();
                        }
                    }
                } else {
                    break;
                }
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

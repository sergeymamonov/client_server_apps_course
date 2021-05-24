package tik_tak;

public class Tik implements Runnable {
    private final int number;
    public static final Monitor monitor = new Monitor();

    public Tik(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        while (TikLine.hasNewLine()) {
            synchronized (monitor) {
                if (number == monitor.getCounter()) {
                    monitor.increaseCounter();
                    System.out.print(number + " ");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    continue;
                }
            }

            try {
                App.BARRIER.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

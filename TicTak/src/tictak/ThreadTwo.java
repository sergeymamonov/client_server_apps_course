package tictak;

public class ThreadTwo implements Runnable {
    private Object monitor;
    private Thread thread;

    public Thread getThread() {
        return thread;
    }

    public ThreadTwo(Object monitor) {
        this.monitor = monitor;
        thread = new Thread(this);
    }

    public void run() {
        try {
            Thread.sleep(1);
            for (int i = 0; i < TicTak.num; i++) {
                System.out.println(2);
                synchronized (monitor) {
                    monitor.notify();
                    if (i < TicTak.num - 1) {
                        monitor.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

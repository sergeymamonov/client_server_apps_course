package tictak;

public class ThreadTwo implements Runnable {
    private int counterTwo = 0;

    @Override
    public void run() {
        while (counterTwo < TicTak.num) {
            if (TicTak.counter.get() == 2) {
                System.out.print(Thread.currentThread().getName() + " - ");
                TicTak.counter.incrementAndGet();
                counterTwo++;
            } else {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

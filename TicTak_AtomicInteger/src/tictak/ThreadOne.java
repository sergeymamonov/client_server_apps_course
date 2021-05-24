package tictak;

public class ThreadOne implements Runnable {
    private int counterOne = 0;

    @Override
    public void run() {
        while (counterOne < TicTak.num) {
            if (TicTak.counter.get() == 1) {
                System.out.print(Thread.currentThread().getName() + " - ");
                TicTak.counter.incrementAndGet();
                counterOne++;
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

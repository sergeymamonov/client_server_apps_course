package tictak;

public class ThreadThree implements Runnable {
    private int counterThree = 0;

    @Override
    public void run() {
        while (counterThree < TicTak.num) {
            if (TicTak.counter.get() == 3) {
                System.out.print(Thread.currentThread().getName() + "\n");
                TicTak.counter.set(1);
                counterThree++;
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

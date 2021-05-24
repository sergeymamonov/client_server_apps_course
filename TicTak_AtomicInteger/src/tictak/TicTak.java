package tictak;

import java.util.concurrent.atomic.AtomicInteger;

public class TicTak {
    static final int num = 10;
    public static AtomicInteger counter = new AtomicInteger(1);

    public static void main(String[] args) {
        Thread thr1 = new Thread(new ThreadOne());
        Thread thr2 = new Thread(new ThreadTwo());
        Thread thr3 = new Thread(new ThreadThree());

        thr1.setName("1");
        thr2.setName("2");
        thr3.setName("3");
        thr1.start();
        thr2.start();
        thr3.start();

        try {
            thr1.join();
            thr2.join();
            thr3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
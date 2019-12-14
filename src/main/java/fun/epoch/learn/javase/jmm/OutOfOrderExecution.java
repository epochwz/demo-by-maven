package fun.epoch.learn.javase.jmm;

import java.util.concurrent.CountDownLatch;

/**
 * 描述：演示 重排序 现象
 */
public class OutOfOrderExecution {
    private static int a, b, x, y;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; noOutOfOrderExecution(i); i++) {
            a = b = x = y = 0;
        }
    }

    // 当 x=0,y=0 时，证明出现了重排序现象 (不能排除是由于可见性问题引起的)
    public static boolean noOutOfOrderExecution(int time) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.countDown();
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a = 1;
                y = b;
            }
        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.countDown();
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                b = 1;
                x = a;
            }
        });

        A.start();
        B.start();
        latch.countDown();
        A.join();
        B.join();

        if (x == 0 && y == 0) {
            System.out.println(String.format("出现了重排序现象：第 %s 次 (%s,%s)", time, x, y));
        }

        return !(x == 0 && y == 0);
    }
}

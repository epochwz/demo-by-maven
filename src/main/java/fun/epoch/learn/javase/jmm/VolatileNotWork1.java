package fun.epoch.learn.javase.jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述：演示 volatile 不适用的场景
 */
public class VolatileNotWork1 {
    private static volatile int count = 0;
    private static AtomicInteger realCount = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10000; i++) {
                count++; // volatile 关键字无法保证原子性
                realCount.incrementAndGet();
            }
        };

        Thread A = new Thread(runnable);
        Thread B = new Thread(runnable);
        A.start();
        B.start();
        A.join();
        B.join();

        System.out.println("实际执行次数：" + realCount);
        System.out.println("线程执行次数：" + count);
    }
}

package fun.epoch.learn.javase.multithread.security;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述：演示 线程安全问题 -- 运行结果出错
 */
public class MultiThreadError1 {
    private static class Counter extends Thread {
        private static int count = 0;
        private static AtomicInteger realCount = new AtomicInteger(0);
        private static AtomicInteger wrongCount = new AtomicInteger(0);
        private static boolean[] marked = new boolean[20001];

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                realCount.incrementAndGet();
                count++;
                synchronized (Counter.class) {
                    if (marked[count]) {
                        wrongCount.incrementAndGet();
                    }
                    marked[count] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();

        counter1.start();
        counter2.start();

        counter1.join();
        counter2.join();

        System.out.println("线程实际执行次数：" + Counter.realCount);
        System.out.println("线程表面执行次数：" + Counter.count);
        System.out.println("线程错误执行次数：" + Counter.wrongCount);
    }
}

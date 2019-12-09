package fun.epoch.learn.javase.multithread.method;

import java.util.concurrent.TimeUnit;

/**
 * 描述：演示 sleep & interrupt 的基本用法
 * <p>
 * 思路：测试线程 T 每秒钟打印一次，主线程对其进行中断，观察 sleep 如何响应中断
 */
public class SleepAndInterrupt {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        // Thread.sleep(5500);
        // 演示 sleep 的优雅写法
        TimeUnit.SECONDS.sleep(5);
        TimeUnit.MILLISECONDS.sleep(500);
        t.interrupt();
    }

    private static class T extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " 已经运行 " + (i + 1) + "s");
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " 被中断了");
                    return;
                }
            }
        }
    }
}

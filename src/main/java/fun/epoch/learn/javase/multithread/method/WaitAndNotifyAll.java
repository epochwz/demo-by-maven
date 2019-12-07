package fun.epoch.learn.javase.multithread.method;

/**
 * 描述：演示 wait & notify & notifyAll 的基本用法
 * <p>
 * 1. 线程 1 和 线程 2 先被阻塞，然后线程 3 唤醒它们 (notify)     -- 其中一个线程无法被唤醒，将会陷入永久等待
 * 2. 线程 1 和 线程 2 先被阻塞，然后线程 3 唤醒它们 (notifyAll)  -- 两个线程都会被唤醒，然后正常执行直至结束
 * 3. 证明先 start 的线程不一定先执行
 */
public class WaitAndNotifyAll {
    private static final Object resource = new Object();

    private static final Runnable runnable = () -> {
        synchronized (resource) {
            try {
                System.out.println(Thread.currentThread().getName() + " 获取到锁了，开始执行");
                System.out.println(Thread.currentThread().getName() + " 已经执行了 wait, 释放了锁并进入等待状态......");
                resource.wait();
                System.out.println(Thread.currentThread().getName() + " 已经被唤醒，重新获得了锁");
                System.out.println(Thread.currentThread().getName() + " 已执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    private static final Runnable runnableC = () -> {
        synchronized (resource) {
            System.out.println(Thread.currentThread().getName() + " 获取到锁了，开始执行");
            resource.notify(); // 1. 其中一个线程无法被唤醒，将会陷入永久等待
            System.out.println(Thread.currentThread().getName() + " 已经执行了 notify");
            System.out.println(Thread.currentThread().getName() + " 已执行完毕");
        }
    };

    public static void main(String[] args) throws InterruptedException {
        Thread A = new Thread(runnable, "线程 A");
        Thread B = new Thread(runnable, "线程 B");
        Thread C = new Thread(runnableC, "线程 C");
        A.start();
        B.start();
        Thread.sleep(100);
        C.start();
    }
}
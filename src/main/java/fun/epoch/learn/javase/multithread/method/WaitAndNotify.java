package fun.epoch.learn.javase.multithread.method;

/**
 * 描述：演示 wait & notify 的基本用法
 * <p>
 * 1. 研究代码的执行顺序
 * 2. 证明 wait 会释放锁 (如果 wait 不会释放锁，则线程 B 无法进入同步代码块唤醒线程 A)
 */
public class WaitAndNotify {
    private static final Object object = new Object();

    private static final Runnable runnableA = () -> {
        synchronized (object) {
            try {
                System.out.println(Thread.currentThread().getName() + " 获取到锁了，开始执行");
                System.out.println(Thread.currentThread().getName() + " 已经执行了 wait, 释放了锁并进入等待状态......");
                object.wait();
                System.out.println(Thread.currentThread().getName() + " 已经被唤醒，重新获得了锁");
                System.out.println(Thread.currentThread().getName() + " 已执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    private static final Runnable runnableB = () -> {
        synchronized (object) {
            System.out.println(Thread.currentThread().getName() + " 获取到锁了，开始执行");
            object.notify();
            System.out.println(Thread.currentThread().getName() + " 已经执行了 notify");
            System.out.println(Thread.currentThread().getName() + " 已执行完毕");
        }
    };

    public static void main(String[] args) throws InterruptedException {
        new Thread(runnableA, "线程 A").start();
        Thread.sleep(100); // 短暂休眠，确保线程启动顺序符合预期
        new Thread(runnableB, "线程 B").start();
    }
}

package fun.epoch.learn.javase.multithread.method;

/**
 * 描述：证明 wait 只会释放对象自己本身的锁
 */
public class WaitOnlyReleaseItsOwnMonitor {
    private static final Object resourceA = new Object();
    private static final Object resourceB = new Object();

    private static final Runnable runnableA = () -> {
        synchronized (resourceA) {
            System.out.println("线程 A 获取到了锁 A, 开始执行");
            synchronized (resourceB) {
                System.out.println("线程 A 获取到了锁 B, 开始执行");
                try {
                    System.out.println("线程 A 已经执行了 wait, 释放了锁 A 并进入等待状态......");
                    resourceA.wait();
                    // 下面的代码永远不会被执行：因为本线程并不会释放锁 B, 所以线程 B 无法获取到锁 B, 也就无法唤醒本线程
                    System.out.println("这是不会被执行的代码：线程 A 已经被唤醒，重新获得了锁 A");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    private static final Runnable runnableB = () -> {
        synchronized (resourceA) {
            System.out.println("线程 B 获取到了锁 A, 正在尝试获取锁 B 中......");
            synchronized (resourceB) {
                // 下面的代码永远不会被执行：因为线程 A 没有释放锁 B, 所以本线程无法获取锁 B
                // 证明：线程 A 中 resourceA.wait 只会释放对象 A 自己本身的锁，而不会释放对象 B 的锁
                System.out.println("这是不会被执行的代码：线程 B 获取到了锁 B, 开始执行");
                resourceA.notifyAll();
                System.out.println("这是不会被执行的代码：线程 B 唤醒了线程 A");
            }
        }
    };

    public static void main(String[] args) throws InterruptedException {
        new Thread(runnableA).start();
        Thread.sleep(100); // 短暂休眠，确保线程启动顺序符合预期
        new Thread(runnableB).start();
    }
}

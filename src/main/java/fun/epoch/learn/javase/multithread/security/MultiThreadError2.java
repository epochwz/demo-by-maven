package fun.epoch.learn.javase.multithread.security;

/**
 * 描述：演示 线程安全问题 -- 死锁
 */
public class MultiThreadError2 {
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lockA) {
                System.out.println(Thread.currentThread().getName() + " 拿到了锁 A，尝试获取锁 B......");
                sleep(111);
                synchronized (lockB) {

                }
            }
        }, "Thread-A").start();

        new Thread(() -> {
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + " 拿到了锁 B，尝试获取锁 A......");
                sleep(123);
                synchronized (lockA) {

                }
            }
        }, "Thread-B").start();
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

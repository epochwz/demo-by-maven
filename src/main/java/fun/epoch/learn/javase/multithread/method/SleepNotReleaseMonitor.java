package fun.epoch.learn.javase.multithread.method;

/**
 * 描述：证明 sleep 不会释放 synchronized 的 monitor 锁
 */
public class SleepNotReleaseMonitor {
    private static Runnable runnable = () -> {
        synchronized (SleepNotReleaseMonitor.class) {
            try {
                System.out.println(Thread.currentThread().getName() + " 获取到锁，开始睡眠，不释放锁");
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + " 已经苏醒，执行完毕，并释放锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public static void main(String[] args) {
        new Thread(runnable).start();
        new Thread(runnable).start();
        // Thread-0 获取到锁，开始睡眠，不释放锁
        // (wait 3s ......)
        // Thread-0 已经苏醒，执行完毕，并释放锁
        // Thread-1 获取到锁，开始睡眠，不释放锁
        // (wait 3s ......)
        // Thread-1 已经苏醒，执行完毕，并释放锁
    }
}

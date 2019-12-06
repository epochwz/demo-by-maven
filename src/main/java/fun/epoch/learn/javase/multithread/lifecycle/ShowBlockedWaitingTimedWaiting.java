package fun.epoch.learn.javase.multithread.lifecycle;

/**
 * 描述；演示线程生命周期的三个状态：BLOCKED、WAITING、TIMED_WAITING
 */
public class ShowBlockedWaitingTimedWaiting {
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread T = new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(1000);
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        T.start();

        Thread.sleep(10);
        System.out.println(T.getState()); // BLOCKED
        Thread.sleep(1000);
        System.out.println(T.getState()); // TIMED_WAITING
        Thread.sleep(1000);
        System.out.println(T.getState()); // WAITING
    }
}

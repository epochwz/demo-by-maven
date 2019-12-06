package fun.epoch.learn.javase.multithread.lifecycle;

/**
 * 描述；演示线程生命周期的六个状态
 */
public class ShowLifeCycle {
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(ShowLifeCycle::blockMethod).start();

        Thread T = new Thread(() -> blockMethod(true));
        System.out.println(T.getState()); // NEW
        T.start();
        System.out.println(T.getState()); // RUNNABLE
        Thread.sleep(10);
        System.out.println(T.getState()); // BLOCKED
        Thread.sleep(1000);
        System.out.println(T.getState()); // TIMED_WAITING
        Thread.sleep(1000);
        System.out.println(T.getState()); // WAITING
        synchronized (lock) {
            lock.notifyAll();
        }
        T.join();
        System.out.println(T.getState()); // TERMINATED
    }

    private static synchronized void blockMethod() {
        blockMethod(false);
    }

    private static synchronized void blockMethod(boolean wait) {
        synchronized (lock) {
            try {
                Thread.sleep(1000);
                if (wait) lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

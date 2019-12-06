package fun.epoch.learn.javase.multithread.lifecycle;

/**
 * 描述；演示线程生命周期的三个状态：NEW、RUNNABLE、TERMINATED
 */
public class ShowNewRunnableTerminated {
    public static void main(String[] args) throws InterruptedException {
        Thread T = new Thread(() -> {
            // 线程的已经就绪状态 (未运行)、正在运行状态 (运行中) 都统一称作 RUNNABLE 状态 (可运行)
            System.out.println(Thread.currentThread().getState()); // RUNNABLE
        });
        System.out.println(T.getState()); // NEW
        T.start();
        System.out.println(T.getState()); // RUNNABLE
        T.join();
        System.out.println(T.getState()); // TERMINATED
    }
}

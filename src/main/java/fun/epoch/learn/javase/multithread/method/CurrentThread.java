package fun.epoch.learn.javase.multithread.method;

/**
 * 描述：证明 Thread.currentThread() 返回的总是当前正在执行的线程的引用
 */
public class CurrentThread {
    public static void main(String[] args) {
        // 直接调用线程的 run 方法并不会创建新的线程，因此当前执行线程还是主线程
        new Thread(runnable).run(); // main
        new Thread(runnable, "Thread-A").start(); // Thread-A
        new Thread(runnable, "Thread-B").start(); // Thread-B
    }

    private static final Runnable runnable = () -> System.out.println("当前正在执行的线程：" + Thread.currentThread().getName());
}

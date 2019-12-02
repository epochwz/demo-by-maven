package fun.epoch.learn.javase.multithread.start;

/**
 * 描述：演示使用 start & run 方法启动线程的区别 (如何正确的启动线程)
 */
public class StartAndRun {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println(Thread.currentThread().getName());
        new Thread(runnable).start();   // 正确的线程启动方式：Thread-0
        new Thread(runnable).run();     // 错误的线程启动方式：main
        // 直接调用线程的 run 方法并不会创建新的线程，而是相当于当前线程 (main) 执行了一个普通的方法
    }
}

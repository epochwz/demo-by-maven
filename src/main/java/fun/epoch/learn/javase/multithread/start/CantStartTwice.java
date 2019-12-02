package fun.epoch.learn.javase.multithread.start;

/**
 * 描述：演示重复启动同一个线程的结果 (不能重复启动一个线程)
 */
public class CantStartTwice {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        thread.start(); // 首次启动线程，线程可以正常执行
        thread.start(); // 再次启动线程，抛出异常：IllegalThreadStateException
    }
}

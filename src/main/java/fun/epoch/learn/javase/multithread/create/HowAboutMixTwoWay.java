package fun.epoch.learn.javase.multithread.create;

/**
 * 描述：演示线程的两种实现方式同时使用的结果
 */
public class HowAboutMixTwoWay {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("这是实现 Runnable 的 run 方法")) {
            @Override
            public void run() {
                System.out.println("这是继承 Thread 类并重写的 run 方法");
            }
        }.start(); // 这是继承 Thread 类并重写的 run 方法
        // 解释：由于方式二直接重写了 run 方法，因此虽然方式一传入了 Runnable, 但却根本没有机会被调用
    }
}

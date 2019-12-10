package fun.epoch.learn.javase.multithread.method;

/**
 * 描述：演示 join & interrupt 的基本用法
 * <p>
 * 1. xx.join 抛出的中断异常需要当前线程 (调用 xx.join 的线程) 来处理 (响应), 而不是 xx
 * 2. 想要 xx.join 抛出中断异常，需要通知的是当前线程 (调用 xx.join 的线程), 而不是 xx
 */
public class JoinAndInterrupt {
    public static void main(String[] args) {
        Thread subThread = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " 开始执行");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " 执行完毕");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " 被中断了！");
            }
        });
        subThread.start();

        // 3s 后中断主线程
        Thread mainThread = Thread.currentThread();
        new Thread(() -> {
            try {
                Thread.sleep(3000);
                mainThread.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            System.out.println(mainThread.getName() + " 正在等待 " + subThread.getName() + " 运行完毕......");
            subThread.join();
            System.out.println(subThread.getName() + " 运行完毕，" + mainThread.getName() + " 执行完毕");
        } catch (InterruptedException e) {
            System.out.println(mainThread.getName() + " 正在等待 " + subThread.getName() + " 的期间被中断了！");
        }
    }
}

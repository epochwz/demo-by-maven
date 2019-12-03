package fun.epoch.learn.javase.multithread.stop;

/**
 * 描述：演示使用中断机制在线程处于阻塞期间停止线程 (run 方法中使用了 sleep / wait 等阻塞线程的方法)
 */
public class StopWithBlocking {
    public static void main(String[] args) throws InterruptedException {
        Thread T = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                if (i % 100 == 0) {
                    System.out.println(i + " 是 100 的倍数");
                }
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("线程在正常运行时响应中断，然后停止执行");
                    return;
                }
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("线程在阻塞状态时响应中断，然后停止执行：" + e.getMessage());
                return;
            }
            System.out.println("线程正常执行完毕");
        });
        T.start();
        Thread.sleep(1000);
        T.interrupt();
    }
}

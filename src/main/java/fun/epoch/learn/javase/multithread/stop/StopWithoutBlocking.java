package fun.epoch.learn.javase.multithread.stop;

/**
 * 描述：演示使用中断机制在线程正常运行期间停止线程 (run 方法中没有使用 sleep / wait 等阻塞线程的方法)
 */
public class StopWithoutBlocking {
    public static void main(String[] args) throws InterruptedException {
        Thread T = new Thread(() -> {
            // 线程自身需要添加相应的 “中断响应处理”，才能确保线程可以被正确停止 (中断)
            for (int i = 0; i < Integer.MAX_VALUE / 2; i++) {
                if (i % 10000 == 0) {
                    System.out.println(i + " 是 10000 的倍数");
                }
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("线程在正常运行时响应中断，然后停止执行");
                    return;
                }
            }
            System.out.println("线程正常执行完毕");
        });
        T.start();
        Thread.sleep(1000);
        T.interrupt(); // 被通知中断的线程如果没有做相应的中断响应处理，则中断不会产生任何效果
    }
}

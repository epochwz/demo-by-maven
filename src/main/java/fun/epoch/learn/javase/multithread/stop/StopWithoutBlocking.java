package fun.epoch.learn.javase.multithread.stop;

/**
 * 描述：演示使用中断机制在线程正常运行期间停止线程 (run 方法中没有使用 sleep / wait 等阻塞线程的方法)
 */
public class StopWithoutBlocking {
    public static void main(String[] args) throws InterruptedException {
        Thread T = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE / 2; i++) {
                if (i % 10000 == 0) {
                    System.out.println(i + " 是 10000 的倍数");
                }
            }
            System.out.println("线程正常执行完毕");
        });
        T.start();
        Thread.sleep(1000);
        T.interrupt(); // 被通知中断的线程如果没有做相应的中断响应处理，则中断不会产生任何效果
    }
}

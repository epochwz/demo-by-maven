package fun.epoch.learn.javase.multithread.stop;

/**
 * 描述：演示 sleep 在响应中断后会立即清除中断标记，从而导致循环中通过判断线程是否已中断来停止线程的方式失效
 */
public class SleepWillClearInterruptedMarkAfterResponseInterruptedException {
    public static void main(String[] args) throws InterruptedException {
        Thread T = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                if (i % 100 == 0) {
                    System.out.println(i + " 是 100 的倍数");
                }
                // 因为 sleep 在响应中断后就会立即清除中断标记，所以此处的判断是无效的 (已经无法检测到线程的已中断状态)
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("线程在正常运行时响应中断，然后停止执行");
                    return;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("线程在迭代中阻塞的期间响应中断，然后停止执行：" + e.getMessage());
                    // 在响应中断处理中没有直接停止线程 (结束 run 方法), 因此循环会继续执行
                }
            }
            System.out.println("线程正常执行完毕");
        });
        T.start();
        Thread.sleep(1000);
        T.interrupt();
    }
}

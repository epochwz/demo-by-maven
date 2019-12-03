package fun.epoch.learn.javase.multithread.stop;

/**
 * 描述：演示使用中断机制在线程每次迭代时都阻塞的情况下停止线程 (run 方法中每次循环时都进行阻塞操作)
 */
public class StopWithBlockingInEveryLoop {
    public static void main(String[] args) throws InterruptedException {
        Thread T = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                if (i % 100 == 0) {
                    System.out.println(i + " 是 100 的倍数");
                }
                // 由于在迭代期间，阻塞所花费的时间占绝对优势，因此这段逻辑实际上基本不可能被执行，可以去除
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("线程在正常执行时响应中断，然后停止执行");
                    return;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("线程在迭代中阻塞的期间响应中断，然后停止执行：" + e.getMessage());
                    return;
                }
            }
            System.out.println("线程正常执行完毕");
        });
        T.start();
        Thread.sleep(1000);
        T.interrupt();
    }
}

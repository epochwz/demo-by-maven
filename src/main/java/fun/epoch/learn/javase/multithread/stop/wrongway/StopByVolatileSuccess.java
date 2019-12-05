package fun.epoch.learn.javase.multithread.stop.wrongway;

/**
 * 描述：停止线程的错误方式 -- 使用 volatile 修饰 boolean 标记位：可行的案例
 */
public class StopByVolatileSuccess {
    private static class T extends Thread {
        private volatile boolean canceled = false;

        @Override
        public void run() {
            for (int i = 0; i < Integer.MAX_VALUE && !canceled; i++) {
                if (i % 100 == 0) {
                    System.out.println(i + " 是 100 的倍数");
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程终止了");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        Thread.sleep(3000);
        t.canceled = true;
    }
}

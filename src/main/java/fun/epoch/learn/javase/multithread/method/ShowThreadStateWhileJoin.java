package fun.epoch.learn.javase.multithread.method;

/**
 * 描述：演示当前线程在 join 期间的状态
 */
public class ShowThreadStateWhileJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();

        Thread subThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("主线程在 join 期间的状态：" + mainThread.getState());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        subThread.start();
        System.out.println("主线程在 join 之前的状态：" + mainThread.getState());
        // subThread.join(3000); // TIMED_WAITING
        subThread.join(); // WAITING
        System.out.println("主线程在 join 之后的状态：" + mainThread.getState());
    }
}

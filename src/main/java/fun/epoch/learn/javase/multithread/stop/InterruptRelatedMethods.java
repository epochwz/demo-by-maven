package fun.epoch.learn.javase.multithread.stop;

/**
 * 描述：演示 interrupt 相关方法
 * <p>
 * Thread.interrupted() 总是返回当前线程的中断状态，然后就清除该线程的中断状态
 */
public class InterruptRelatedMethods {
    public static void main(String[] args) {
        Thread T = new Thread(() -> {
            while (true) {
            }
        });
        T.start();
        System.out.println(T.getName() + " 的中断状态：" + T.isInterrupted());    // false
        T.interrupt();
        System.out.println(T.getName() + " 的中断状态：" + T.isInterrupted());    // true
        System.out.println(T.getName() + " 的中断状态：" + T.interrupted());      // false
        System.out.println(T.getName() + " 的中断状态：" + Thread.interrupted()); // false
        System.out.println(T.getName() + " 的中断状态：" + T.isInterrupted());    // true

        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread.getName() + " 的中断状态：" + mainThread.isInterrupted());  // false
        mainThread.interrupt();
        System.out.println(mainThread.getName() + " 的中断状态：" + mainThread.isInterrupted());  // true
        System.out.println(mainThread.getName() + " 的中断状态：" + mainThread.interrupted());    // true
        System.out.println(mainThread.getName() + " 的中断状态：" + Thread.interrupted());        // false
        System.out.println(mainThread.getName() + " 的中断状态：" + mainThread.isInterrupted());  // false

        T.stop();
    }
}

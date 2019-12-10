package fun.epoch.learn.javase.multithread.method;

/**
 * 描述：理解 join 的底层原理，实现其等价写法
 * <p>
 * 原理：
 * 1. Thread 类实例的 join 方法实际上调用了自身的 wait 方法 (Thread 类实例自然也是一个 Object 类实例)
 * 2. JVM 执行完线程的 run 方法后，会自动调用其 notifyAll 方法，因此处于 wait 状态的线程就会被唤醒
 */
public class JoinPrinciple {
    public static void main(String[] args) throws InterruptedException {
        Thread T = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " 开始执行");
                for (int i = 0; i < 3; i++) {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " 正在执行 " + (i + 1) + "s");
                }
                System.out.println(Thread.currentThread().getName() + " 执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        T.start();
        T.join();
        System.out.println(Thread.currentThread().getName() + " 执行完毕");
    }
}

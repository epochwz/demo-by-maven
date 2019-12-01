package fun.epoch.learn.javase.multithread.create;

/**
 * 描述：演示线程的两种实现方式
 * <p>
 * 方式一：实现 Runnable 接口
 * 方式二：继承 Thread 类
 */
public class HowToCreateANewThread {
    private static class RunnableStyle implements Runnable {
        @Override
        public void run() {
            System.out.println("实现线程的方式一：实现 Runnable 接口");
        }
    }

    private static class ThreadStyle extends Thread {
        @Override
        public void run() {
            System.out.println("实现线程的方式二：继承 Thread 类");
        }
    }

    public static void main(String[] args) {
        // 创建线程：实现 Runnable 接口，然后传入 Thread 类
        Thread thread1 = new Thread(new RunnableStyle());
        thread1.start();

        // 创建线程：继承 Thread 类，然后直接重写 run 方法
        ThreadStyle thread2 = new ThreadStyle();
        thread2.start();
    }
}

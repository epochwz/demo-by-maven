package fun.epoch.learn.javase.multithread.method;

/**
 * 描述：使用两个线程交替打印奇偶数 0~100
 * <p>
 * 实现：使用 wait & notify 实现
 * 思路：一旦获得锁便执行有效逻辑，然后唤醒另一个线程，同时自身进入等待状态
 * 缺点：如果不保证线程的启动顺序，则无法确定它们各自的职责 (打印奇数/偶数)
 */
public class PrintsEvenAndOddByWaitAndNotify {
    private static final Object printer = new Object();
    private static int counter = 0;

    private static class Printer extends Thread {
        public Printer(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (printer) {
                while (counter <= 100) {
                    System.out.println(Thread.currentThread().getName() + " print: " + counter++);
                    try {
                        printer.notify();
                        printer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                printer.notify(); // 确保可以唤醒最后一次执行的线程，使得程序顺序终止
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Printer oddPrinter = new Printer("OddPrinter");
        Printer evenPrinter = new Printer("EvenPrinter");

        oddPrinter.start();
        Thread.sleep(100); // 短暂休眠，确保线程启动顺序符合预期
        evenPrinter.start();
    }
}

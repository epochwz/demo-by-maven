package fun.epoch.learn.javase.multithread.method;

/**
 * 描述：使用两个线程交替打印奇偶数 0~100
 * <p>
 * 实现：使用 synchronized 实现
 * 思路：两个线程通过竞争锁获得执行权，然后只有在满足条件时 (当前数字刚好是自己需要打印的奇/偶数)，才真正执行有效逻辑
 * 缺点：可能出现同一个线程连续获得锁，但由于不满足条件而不能执行有效逻辑，从而造成资源浪费
 */
public class PrintsEvenAndOddBySynchronized {
    private static final Object printer = new Object();
    private static int counter = 0;

    public static void main(String[] args) {
        Thread evenPrinter = new Thread(() -> {
            while (counter < 100) {
                synchronized (printer) {
                    if ((counter & 1) == 1) {
                        System.out.println(Thread.currentThread().getName() + " print: " + counter++);
                    }
                }
            }
        }, "EvenPrinter");

        Thread oddPrinter = new Thread(() -> {
            while (counter < 100) {
                synchronized (printer) {
                    if ((counter & 1) == 0) {
                        System.out.println(Thread.currentThread().getName() + " print: " + counter++);
                    }
                }
            }
        }, "OddPrinter");

        evenPrinter.start();
        oddPrinter.start();
    }
}

package fun.epoch.learn.javase.multithread.stop.wrongway;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 描述：停止线程的错误方式 -- 使用 volatile 修饰 boolean 标记位：失败的案例
 * <p>
 * 演示：如果设置标记位时线程刚好处于阻塞状态，那么标记位的判断就会失效 (根本无法走到进行判断的代码)
 */
public class StopByVolatileFailed {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> storage = new ArrayBlockingQueue<>(10);
        Producer producer = new Producer(storage);
        Consumer consumer = new Consumer(storage);

        producer.start();

        while (consumer.needMoreProducts()) {
            Thread.sleep(1000); // 消费者速度较慢，从而确保生产者时常处于阻塞状态
            System.out.println("消费者消费了 " + consumer.storage.take());
        }
        Thread.sleep(1000); // 确保生产者在生产足够的产品后，线程必然处于阻塞状态
        producer.canceled = true;
        if (producer.canceled) {
            System.out.println("消费者停止消费");
            System.out.println("生产者线程状态：" + producer.getState()); // WAITING // 说明线程处于阻塞状态会导致使用标记位停止线程的方式失效
            System.out.println("生产者的标记位：canceled=" + producer.canceled);
        }
    }

    private static class Producer extends Thread {
        private BlockingQueue<Integer> storage;

        public Producer(BlockingQueue<Integer> storage) {
            this.storage = storage;
        }

        public volatile boolean canceled = false;

        @Override
        public void run() {
            try {
                for (int i = 0; i < Integer.MAX_VALUE && !canceled; i++) {
                    if (i % 100 == 0) {
                        storage.put(i);
                        System.out.println("生产者生产了 " + i);
                    }
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("生产者停止生产了");
            }
        }
    }

    private static class Consumer extends Thread {
        public BlockingQueue<Integer> storage;

        public Consumer(BlockingQueue<Integer> storage) {
            this.storage = storage;
        }

        private int count = 0;

        public boolean needMoreProducts() {
            return count++ < 5;
        }
    }
}

package fun.epoch.learn.javase.multithread.method;

import java.util.Date;
import java.util.LinkedList;

/**
 * 描述：使用 wait & notify 实现生产者消费者模式
 */
public class ProducerConsumerModel {
    public static void main(String[] args) {
        EventStorage eventStorage = new EventStorage(10);

        new Producer(eventStorage).start();
        new Consumer(eventStorage).start();
    }

    private static class Producer extends Thread {
        private EventStorage storage;

        public Producer(EventStorage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                storage.put(new Date());
            }
        }
    }

    private static class Consumer extends Thread {
        private EventStorage storage;

        public Consumer(EventStorage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                storage.pop();
            }
        }
    }


    // 事件队列
    private static class EventStorage {
        private int capacity;
        private LinkedList<Date> events = new LinkedList<>();

        public EventStorage(int capacity) {
            this.capacity = capacity;
        }

        public boolean isEmpty() {
            return events.size() == 0;
        }

        public boolean isFully() {
            return events.size() == capacity;
        }

        public int size() {
            return events.size();
        }

        public synchronized void put(Date event) {
            while (isFully()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            events.add(event);
            System.out.println("生产者完成生产，队列中还剩 " + size() + " 个事件");
            notifyAll();
        }

        public synchronized void pop() {
            while (isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("消费者消费了 " + events.poll() + ", 队列中还剩 " + size() + " 个事件");
            notifyAll();
        }
    }
}

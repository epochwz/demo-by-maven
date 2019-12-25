package fun.epoch.learn.design.pattern.creational.singleton.related;

/**
 * 线程单例：给每个线程都提供一个唯一的对象，避免多线程访问时的相互影响
 */
public class ThreadSingleton {
    private static final ThreadLocal<ThreadSingleton> ThreadLocalInstance = ThreadLocal.withInitial(ThreadSingleton::new);

    public static ThreadSingleton getInstance() {
        return ThreadLocalInstance.get();
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": " + ThreadSingleton.getInstance());
        new Thread(() -> System.out.println(Thread.currentThread().getName() + ": " + ThreadSingleton.getInstance())).start();
        new Thread(() -> System.out.println(Thread.currentThread().getName() + ": " + ThreadSingleton.getInstance())).start();
        System.out.println(Thread.currentThread().getName() + ": " + ThreadSingleton.getInstance());
    }
}

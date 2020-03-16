package fun.epoch.learn.design.pattern.creational.singleton;

/**
 * 多线程测试
 */
public class MultiThreadTest {
    public static void main(String[] args) throws InterruptedException {
        T A = new T();
        T B = new T();
        A.start();
        B.start();
        A.join();
        B.join();
        System.out.println(A.singleton == B.singleton); // false
        System.out.println(A.singleton);
        System.out.println(B.singleton);
    }

    private static class T extends Thread {
        LazySingleton singleton;

        @Override
        public void run() {
            singleton = LazySingleton.getInstance();
        }
    }
}

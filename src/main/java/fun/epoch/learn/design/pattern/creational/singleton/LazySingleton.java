package fun.epoch.learn.design.pattern.creational.singleton;

/**
 * 懒汉式
 */
public class LazySingleton {
    private static LazySingleton instance;

    // 1. 私有构造器
    private LazySingleton() {
        // 模拟单例对象复杂的初始化过程
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 2. 全局访问点
    public static LazySingleton getInstance() {
        // 使用双重检查，避免每次获取对象时都需要加锁，从而解决加锁造成的性能问题
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}

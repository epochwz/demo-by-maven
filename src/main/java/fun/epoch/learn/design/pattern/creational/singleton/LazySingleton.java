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
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

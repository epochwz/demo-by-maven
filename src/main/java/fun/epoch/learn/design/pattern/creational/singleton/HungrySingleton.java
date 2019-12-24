package fun.epoch.learn.design.pattern.creational.singleton;

/**
 * 饿汉式
 */
public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();

    // 1. 私有构造器
    private HungrySingleton() {

    }

    // 2. 全局访问点
    public static HungrySingleton getInstance() {
        return instance;
    }
}

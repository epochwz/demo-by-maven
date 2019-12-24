package fun.epoch.learn.design.pattern.creational.singleton;

import java.io.Serializable;

/**
 * 饿汉式
 */
public class HungrySingleton implements Serializable, Cloneable {
    private static final HungrySingleton instance = new HungrySingleton();

    // 1. 私有构造器
    private HungrySingleton() {

    }

    // 2. 全局访问点
    public static HungrySingleton getInstance() {
        return instance;
    }

    // 防御单例破坏 (反序列化)：实现 readResolve 方法 或者 不要实现 Serializable 接口
    private Object readResolve() {
        return instance;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

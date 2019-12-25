package fun.epoch.learn.design.pattern.creational.singleton;

/**
 * 懒汉式：基于 静态内部类 实现
 * <p>
 * 延迟加载：基于 静态内部类 实现懒加载 -- 仅当调用 getInstance() 时才会访问到内部类，从而创建并初始化单例类的实例
 * 线程安全：基于类初始化机制 (Class 对象的初始化锁) 保证线程安全，同时可以屏蔽 指令重排序 的过程 (其他线程无法看到)
 */
public class StaticInnerClassSingleton {
    // 1. 私有构造器
    private StaticInnerClassSingleton() {

    }

    // 2. 全局访问点
    public static StaticInnerClassSingleton getInstance() {
        return InnerClass.instance;
    }

    private static class InnerClass {
        private static final StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
    }
}

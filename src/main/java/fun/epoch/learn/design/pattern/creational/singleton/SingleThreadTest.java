package fun.epoch.learn.design.pattern.creational.singleton;

/**
 * 单线程测试
 */
public class SingleThreadTest {
    public static void main(String[] args) {
        // LazySingleton lazySingleton = new LazySingleton(); // 编译错误：只能通过单例类提供的全局访问点获取实例
        LazySingleton instance1 = LazySingleton.getInstance();
        LazySingleton instance2 = LazySingleton.getInstance();
        System.out.println(instance1 == instance2); // true
    }
}

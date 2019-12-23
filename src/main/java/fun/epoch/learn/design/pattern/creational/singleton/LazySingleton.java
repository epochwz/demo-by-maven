package fun.epoch.learn.design.pattern.creational.singleton;

/**
 * 懒汉式
 */
public class LazySingleton {
    // 使用 volatile 禁止指令重排序，解决 双重检查 模式存在的线程安全隐患
    private static volatile LazySingleton instance;

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
                    /*
                     * 实例初始化时可能会发生指令重排序，从而导致严重的线程安全问题 (空指针异常)
                     *
                     * 正常的执行顺序
                     * 1. 给对象分配内存空间
                     * 2. 初始化对象
                     * -  其他线程尝试获取对象：此时必然会在外层判空中检查到对象仍然为空，然后等待进入 synchronized 代码块
                     * -  当能够进入时则表明最早持有锁的线程已经执行完指令 2 & 3, 此时在内层判空中会检查到对象不为空并返回
                     * 3. 将对象的内存地址赋值给 instance
                     * -  只有当最早持有锁的线程执行完指令 3 并释放锁之后 (此时指令 2 必然也已经执行完毕)
                     * -  其他线程才有可能检查到对象非空并返回使用，此时对象已经完成初始化，没有 NPE 问题
                     *
                     * 指令重排序之后
                     * 1. 给对象分配内存空间
                     * 2. 将对象的内存地址赋值给 instance
                     * -  其他线程尝试获取对象：此时会在外层判空中检查到对象不为空并返回 (但是此时该对象仍然处于初始化过程中)
                     * -  因此在使用单例对象时便可能访问到那些尚未完成初始化的属性，从而导致发生空指针异常
                     * 3. 初始化对象
                     */
                }
            }
        }
        return instance;
    }
}

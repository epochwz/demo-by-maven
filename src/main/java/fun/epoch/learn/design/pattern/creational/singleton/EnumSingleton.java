package fun.epoch.learn.design.pattern.creational.singleton;

/**
 * 饿汉式：基于 枚举类 实现
 * <p>
 * 线程安全：基于类初始化机制保证线程安全
 * 安全性保证
 * - 反序列化：ObjectInputStream.readObject() 中针对枚举类做了特殊处理 -- 总是返回枚举类所持有的相应实例
 * - 反射调用：Constructors.newInstance() 中针对枚举类做了特殊处理 -- 直接抛出异常
 * - 克隆调用：Enum 使用 protected final 修饰 clone, 因此继承自 Enum 的枚举类无法重写 clone, 自然也就无法被克隆
 */
public enum EnumSingleton implements Cloneable {
    INSTANCE;

    // 此处实现该方法仅仅是为了凸显这是一个单例类
    // 实际上需要获取枚举类单例对象时直接调用 EnumSingleton.INSTANCE 即可
    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}

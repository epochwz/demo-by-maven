package fun.epoch.learn.design.pattern.creational.factorymethod;

// 代码演进：各个对象的创建逻辑逐渐变得十分复杂，简单工厂日益臃肿，因此难以维护
// 代码优化：使用工厂方法将各个类对象的创建逻辑推迟到相对应的工厂实现类中去实现
public abstract class VideoFactory {
    public abstract Video getVideo();
}

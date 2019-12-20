package fun.epoch.learn.design.pattern.creational.factorymethod;

import fun.epoch.learn.design.pattern.creational.factorymethod.factory.GoVideoFactory;
import fun.epoch.learn.design.pattern.creational.factorymethod.factory.JavaVideoFactory;
import fun.epoch.learn.design.pattern.creational.factorymethod.factory.PythonVideoFactory;

// 代码演进：各个对象的创建逻辑逐渐变得十分复杂，简单工厂日益臃肿，因此难以维护
// 代码优化：使用工厂方法将各个类对象的创建逻辑推迟到相对应的工厂实现类中去实现
public abstract class VideoFactory {
    public abstract Video getVideo();

    // 使用简单工厂统一创建工厂实现类，将其依赖性从应用层转移到简单工厂类
    public static VideoFactory getVideoFactory(int day) {
        switch (day % 7) {
            case 0:
                return new PythonVideoFactory();
            case 1:
                return new JavaVideoFactory();
            case 2:
                return new GoVideoFactory();
            default:
                return null;
        }
    }
}

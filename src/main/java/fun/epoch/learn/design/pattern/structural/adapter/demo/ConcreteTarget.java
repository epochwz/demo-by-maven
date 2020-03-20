package fun.epoch.learn.design.pattern.structural.adapter.demo;

/**
 * 适配目标接口 的 原始实现类
 */
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("我是 适配目标原始实现类 的方法");
    }
}

package fun.epoch.learn.design.pattern.structural.adapter.demo;

public class Test {
    public static void main(String[] args) {
        // 适配目标接口
        Target target;

        // 适配目标原始实现类
        target = new ConcreteTarget();
        target.request();

        // 适配目标适配实现类
        target = new Adapter();
        target.request();
    }
}

package fun.epoch.learn.design.pattern.structural.adapter.demo;

/**
 * 适配目标接口 的 适配实现类
 */
public class Adapter implements Target {
    private Adapted adapted = new Adapted();

    @Override
    public void request() {
        adapted.adaptedRequest();
    }
}

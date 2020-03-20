package fun.epoch.learn.design.pattern.structural.adapter.demo;

/**
 * 适配目标接口 的 适配实现类
 */
public class Adapter extends Adapted implements Target {
    @Override
    public void request() {
        super.adaptedRequest();
    }
}

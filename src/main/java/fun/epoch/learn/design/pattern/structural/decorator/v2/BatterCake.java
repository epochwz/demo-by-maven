package fun.epoch.learn.design.pattern.structural.decorator.v2;

/**
 * 具体的被装饰者
 */
public class BatterCake extends AbstractBatterCake {
    @Override
    public String desc() {
        return "煎饼";
    }

    @Override
    public int cost() {
        return 8;
    }
}

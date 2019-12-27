package fun.epoch.learn.design.pattern.structural.decorator.v2;

/**
 * 抽象的被装饰者
 */
public abstract class AbstractBatterCake {
    public abstract String desc();

    public abstract int cost();

    @Override
    public String toString() {
        return desc() + " 的销售价格是 " + cost() + " 元";
    }
}

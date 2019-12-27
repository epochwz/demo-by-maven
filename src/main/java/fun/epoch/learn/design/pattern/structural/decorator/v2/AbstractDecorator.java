package fun.epoch.learn.design.pattern.structural.decorator.v2;

/**
 * 抽象的装饰者
 */
public abstract class AbstractDecorator extends AbstractBatterCake {
    private AbstractBatterCake batterCake;

    public AbstractDecorator(AbstractBatterCake batterCake) {
        this.batterCake = batterCake;
    }

    @Override
    public String desc() {
        return batterCake.desc();
    }

    @Override
    public int cost() {
        return batterCake.cost();
    }
}

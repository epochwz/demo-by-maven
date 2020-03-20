package fun.epoch.learn.design.pattern.structural.decorator.v2;

public class SausageDecorator extends AbstractDecorator {
    public SausageDecorator(AbstractBatterCake batterCake) {
        super(batterCake);
    }

    @Override
    public String desc() {
        return super.desc() + " + 香肠";
    }

    @Override
    public int cost() {
        return super.cost() + 2;
    }
}

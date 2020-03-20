package fun.epoch.learn.design.pattern.structural.decorator.v2;

public class EggDecorator extends AbstractDecorator {
    public EggDecorator(AbstractBatterCake batterCake) {
        super(batterCake);
    }

    @Override
    public String desc() {
        return super.desc() + " + 鸡蛋";
    }

    @Override
    public int cost() {
        return super.cost() + 1;
    }
}

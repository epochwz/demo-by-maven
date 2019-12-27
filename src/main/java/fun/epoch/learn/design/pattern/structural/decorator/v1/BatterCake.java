package fun.epoch.learn.design.pattern.structural.decorator.v1;

public class BatterCake {
    protected String desc() {
        return "煎饼";
    }

    protected int cost() {
        return 8;
    }

    @Override
    public String toString() {
        return desc() + " 的销售价格是 " + cost() + " 元";
    }
}

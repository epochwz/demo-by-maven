package fun.epoch.learn.design.pattern.structural.decorator.v1;

public class BatterCakeWithEgg extends BatterCake {
    @Override
    protected String desc() {
        return super.desc() + " + 鸡蛋";
    }

    @Override
    protected int cost() {
        return super.cost() + 1;
    }
}

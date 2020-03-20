package fun.epoch.learn.design.pattern.structural.decorator.v1;

public class BatterCakeWithSausage extends BatterCake {
    @Override
    protected String desc() {
        return super.desc() + " + 香肠";
    }

    @Override
    protected int cost() {
        return super.cost() + 2;
    }
}

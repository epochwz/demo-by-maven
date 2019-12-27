package fun.epoch.learn.design.pattern.structural.decorator.v1;

public class BatterCakeWithEggSausage extends BatterCakeWithEgg {
    @Override
    protected String desc() {
        return super.desc() + " + 香肠";
    }

    @Override
    protected int cost() {
        return super.cost() + 2;
    }
}

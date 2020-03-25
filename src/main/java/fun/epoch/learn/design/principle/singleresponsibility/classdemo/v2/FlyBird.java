package fun.epoch.learn.design.principle.singleresponsibility.classdemo.v2;

/**
 * 单一职责：描述 会飞的鸟 的移动方式
 */
public class FlyBird extends Bird {
    public FlyBird(String birdName) {
        super(birdName);
    }

    @Override
    public void move() {
        System.out.println(getBirdName() + " 用翅膀飞");
    }
}

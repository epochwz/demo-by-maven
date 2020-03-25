package fun.epoch.learn.design.principle.singleresponsibility.classdemo.v2;

/**
 * 单一职责：描述 会走的鸟 的移动方式
 */
public class WalkBird extends Bird {
    public WalkBird(String birdName) {
        super(birdName);
    }

    @Override
    public void move() {
        System.out.println(getBirdName() + "用脚走");
    }
}

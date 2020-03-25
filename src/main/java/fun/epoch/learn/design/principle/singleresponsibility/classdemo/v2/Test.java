package fun.epoch.learn.design.principle.singleresponsibility.classdemo.v2;

/**
 * 需求扩展：描述鸵鸟的移动方式
 */
public class Test {
    public static void main(String[] args) {
        new FlyBird("大雁").move();
        new WalkBird("鸵鸟").move(); // 由于类的职责单一，需求的扩展不需要改变旧有的类，因此降低了修改带来的风险
    }
}

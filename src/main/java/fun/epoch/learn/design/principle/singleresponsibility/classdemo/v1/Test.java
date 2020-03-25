package fun.epoch.learn.design.principle.singleresponsibility.classdemo.v1;

/**
 * 需求扩展：描述鸵鸟的移动方式
 */
public class Test {
    public static void main(String[] args) {
        new Bird("大雁").move();
        new Bird("鸵鸟").move(); // 由于鸵鸟不会飞，因此原本的实现不符合需求，所以需要进行修改从而达到扩展的目的
    }
}

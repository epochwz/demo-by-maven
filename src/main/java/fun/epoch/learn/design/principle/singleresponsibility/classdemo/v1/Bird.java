package fun.epoch.learn.design.principle.singleresponsibility.classdemo.v1;

import lombok.AllArgsConstructor;

/**
 * 职责：描述鸟类的移动方式
 */
@AllArgsConstructor
public class Bird {
    private String birdName;

    public void move() {
        if ("鸵鸟".equals(birdName)) {
            System.out.println(birdName + " 用脚走");
        }
        System.out.println(birdName + " 用翅膀飞");
    }
}

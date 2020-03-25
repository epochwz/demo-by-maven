package fun.epoch.learn.design.principle.singleresponsibility.classdemo.v1;

import lombok.AllArgsConstructor;

/**
 * 职责：描述鸟类的移动方式
 * <p>
 * 职责一：描述 会飞的鸟 的移动方式
 * 职责二：描述 会走的鸟 的移动方式
 * <p>
 * 职责不单一：需要同时负责描述 会飞的鸟 和 会走的鸟 这两种鸟类的移动方式
 * 经常要修改：后续可能还需要增加诸如 会游泳的鸟 (企鹅) 等各种类型的鸟类
 */
@AllArgsConstructor
public class Bird {
    private String birdName;

    public void move() {
        if ("鸵鸟".equals(birdName)) {
            System.out.println(birdName + " 用脚走");
        } // 此处缺少 else 逻辑：因为该类的职责不单一，所以需要经常修改，且修改时容易引入风险
        System.out.println(birdName + " 用翅膀飞");
    }
}

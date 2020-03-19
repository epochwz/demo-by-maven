package fun.epoch.learn.design.pattern.behavioral.strategy;

import fun.epoch.learn.design.pattern.behavioral.strategy.promotionstrategy.LiJianPromotionStrategy;
import fun.epoch.learn.design.pattern.behavioral.strategy.promotionstrategy.ManJianPromotionStrategy;

public class Test {
    public static void main(String[] args) {
        PromotionActivity activity618 = new PromotionActivity(new LiJianPromotionStrategy());
        activity618.executePromotionStrategy();

        PromotionActivity activity1111 = new PromotionActivity(new ManJianPromotionStrategy());
        activity1111.executePromotionStrategy();
    }
}

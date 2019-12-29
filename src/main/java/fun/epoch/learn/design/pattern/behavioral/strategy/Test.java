package fun.epoch.learn.design.pattern.behavioral.strategy;

import fun.epoch.learn.design.pattern.behavioral.strategy.promotionstrategy.LiJianPromotionStrategy;
import fun.epoch.learn.design.pattern.behavioral.strategy.promotionstrategy.ManJianPromotionStrategy;

public class Test {
    public static void main(String[] args) {
        // 代码演进：需要按照日期选择促销策略
        for (int i = 0; i < 7; i++) {
            int promotionKey = (int) (Math.random() * 8);

            PromotionActivity activity = null;

            if (promotionKey == 0) {
                activity = new PromotionActivity(new LiJianPromotionStrategy());
            }
            if (promotionKey == 1) {
                activity = new PromotionActivity(new ManJianPromotionStrategy());
            }

            if (activity != null) {
                activity.executePromotionStrategy();
            }
        }
    }
}

package fun.epoch.learn.design.pattern.behavioral.strategy;

import fun.epoch.learn.design.pattern.behavioral.strategy.promotionstrategy.PromotionStrategy;
import fun.epoch.learn.design.pattern.behavioral.strategy.promotionstrategy.PromotionStrategyFactory;

public class Test {
    public static void main(String[] args) {
        // 代码演进：需要按照日期选择促销策略
        for (int i = 0; i < 7; i++) {
            int promotionKey = (int) (Math.random() * 8);
            PromotionStrategy promotionStrategy = PromotionStrategyFactory.getPromotionStrategy(promotionKey);
            PromotionActivity activity = new PromotionActivity(promotionStrategy);
            activity.executePromotionStrategy();
        }
    }
}

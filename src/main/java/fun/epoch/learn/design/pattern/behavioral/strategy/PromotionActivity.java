package fun.epoch.learn.design.pattern.behavioral.strategy;

import fun.epoch.learn.design.pattern.behavioral.strategy.promotionstrategy.PromotionStrategy;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PromotionActivity {
    private PromotionStrategy promotionStrategy;

    public void executePromotionStrategy() {
        promotionStrategy.doPromotion();
    }
}

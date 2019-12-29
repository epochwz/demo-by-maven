package fun.epoch.learn.design.pattern.behavioral.strategy.promotionstrategy;

public class DefaultPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("无促销活动");
    }
}

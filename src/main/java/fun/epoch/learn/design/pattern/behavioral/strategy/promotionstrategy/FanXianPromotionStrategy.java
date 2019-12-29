package fun.epoch.learn.design.pattern.behavioral.strategy.promotionstrategy;

public class FanXianPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("返现促销：返还金额到用户余额中...");
    }
}

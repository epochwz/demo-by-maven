package fun.epoch.learn.design.pattern.behavioral.strategy.promotionstrategy;

public class LiJianPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("立减促销：课程价格直接减去立减价格");
    }
}

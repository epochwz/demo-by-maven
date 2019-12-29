package fun.epoch.learn.design.pattern.behavioral.strategy.promotionstrategy;

public class ManJianPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("满减促销：课程价格满 400 减 200");
    }
}

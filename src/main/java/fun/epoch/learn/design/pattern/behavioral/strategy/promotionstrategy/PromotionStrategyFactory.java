package fun.epoch.learn.design.pattern.behavioral.strategy.promotionstrategy;

import java.util.HashMap;
import java.util.Map;

public class PromotionStrategyFactory {
    private static final Map<Integer, PromotionStrategy> map = new HashMap<>();

    static {
        map.put(PromotionsKey.DEFAULT, new DefaultPromotionStrategy());
        map.put(PromotionsKey.LIJIAN, new LiJianPromotionStrategy());
        map.put(PromotionsKey.MANJIAN, new ManJianPromotionStrategy());
        map.put(PromotionsKey.FANXIAN, new FanXianPromotionStrategy());
    }

    public static PromotionStrategy getPromotionStrategy(int key) {
        PromotionStrategy strategy = map.get(key);
        if (strategy == null) {
            strategy = map.get(PromotionsKey.DEFAULT);
        }
        return strategy;
    }

    public interface PromotionsKey {
        int DEFAULT = Integer.MIN_VALUE;
        int LIJIAN = 0;
        int MANJIAN = 1;
        int FANXIAN = 2;
    }
}

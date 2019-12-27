package fun.epoch.learn.design.pattern.structural.decorator.v2;

/**
 * 需求描述：在煎饼的基础上添加各种配料，并计算价格
 * <p>
 * 需求实现：
 * 1. 煎饼
 * 2. 煎饼 + 鸡蛋
 * 3. 煎饼 + 香肠
 * <p>
 * 需求扩展：
 * 4. 煎饼 + 鸡蛋 + 香肠
 * <p>
 * 基于 装饰者 实现：可以实现现有煎饼和配料的任意组合，仅当出现新的煎饼或配料时才需要创建相应的类，符合开闭原则
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(new BatterCake());
        System.out.println(new EggDecorator(new BatterCake()));
        System.out.println(new SausageDecorator(new BatterCake()));
        System.out.println(new SausageDecorator(new EggDecorator(new BatterCake())));
    }
}

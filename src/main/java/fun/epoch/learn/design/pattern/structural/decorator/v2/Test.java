package fun.epoch.learn.design.pattern.structural.decorator.v2;

/**
 * 需求描述：在煎饼的基础上添加各种配料，并计算价格
 * <p>
 * 需求实现：
 * 1. 煎饼
 * 2. 煎饼 + 鸡蛋
 * 3. 煎饼 + 香肠
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(new BatterCake());
        System.out.println(new EggDecorator(new BatterCake()));
        System.out.println(new SausageDecorator(new BatterCake()));
    }
}

package fun.epoch.learn.design.pattern.structural.decorator.v1;

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
 * 基于 类继承 实现：每当需要实现一种新的煎饼和配料的组合时，就需要通过继承实现一个新的类，十分麻烦且容易产生类爆炸
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(new BatterCake());
        System.out.println(new BatterCakeWithEgg());
        System.out.println(new BatterCakeWithSausage());
        System.out.println(new BatterCakeWithEggSausage());
    }
}
